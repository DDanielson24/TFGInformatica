package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.PuntoDeMedicion;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PSQLConnectionTrafico {

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DATABASE = "TFGInformatica";
    private final String USER = "fdaniel";
    private final String PASSWORD = "TFGInformatica";
    private String url = "jdbc:postgresql://" + HOST + ":" + PUERTO + "/" + DATABASE;
    private Connection conn = null;
    private CoordConverter coordConverter = new CoordConverter();

    public void connect() {
        try {

            conn = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Se ha conectado exitosamente a la BD: " + DATABASE);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ha surgido un error al conectarse a la BD: " + DATABASE);
        }
    }

    public boolean addRow(PuntoDeMedicion pm) {

        boolean query = false;
        if (this.checkIfExists(pm)) { //UPDATE

            try {
                Statement statement = conn.createStatement();
                statement.execute(
                        "UPDATE \"PuntosDeMedicion\" " +
                        "SET intensidad = " + pm.getIntensidad() + ", " +
                            "carga = " + pm.getCarga() + ", " +
                            "nivel_servicio = " + pm.getNivelServicio() + ", " +
                            "fecha_actualizacion = '" + pm.getFechaActualizacion() + "' " +
                        "WHERE idelem = " + pm.getIdelem() + ";");
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ha sido actualizado en la BD");
                query = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return query;

        }
        else { //INSERT

            float resultConverted[] = coordConverter.convertUTMToLatLong(Float.toString(pm.getStX()), Float.toString(pm.getStY()));
            try {
                Statement statement = conn.createStatement();
                statement.execute(
                        "INSERT INTO \"UbicacionesLatLong\" " +
                                "VALUES (" + pm.getIdelem() + ", " + resultConverted[0] +
                                ", " + resultConverted[1] + ");");
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ha sido insertado en la BD: UbicacionesLatLong");
                statement.execute(
                        "INSERT INTO \"PuntosDeMedicion\" " +
                        "VALUES (" + pm.getIdelem() + ", '" + pm.getDescripcion() + "', " +
                                pm.getIntensidad() + ", " + pm.getCarga() + ", " +
                                pm.getNivelServicio() + ", '" + pm.getFechaActualizacion() + "');");
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ha sido insertado en la BD: PuntosDeMedicion");
                query = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return query;
        }
    }

    private boolean checkIfExists(PuntoDeMedicion pm) {

        boolean query = false;
        try {

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT EXISTS " +
                    "(SELECT * FROM \"PuntosDeMedicion\" " +
                    "WHERE idelem = " + pm.getIdelem() + ");");
            while (resultSet.next()) {
                query = resultSet.getBoolean("exists");
            }
            return query;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;

    }
}
