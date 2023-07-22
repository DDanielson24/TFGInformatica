package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.TraficoPuntoDeMedicion;
import org.TFGInformatica.TraficoPuntoDeMedicion;

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

    public boolean addRow(TraficoPuntoDeMedicion pm) {

        boolean query = false;

        float resultConverted[] = coordConverter.convertUTMToLatLong(Float.toString(pm.getStX()), Float.toString(pm.getStY()));
        try {
            Statement statement = conn.createStatement();

            //Comprobamos si está ya en la BD UbicacionesLatLong
            if (!this.checkIfExists("UbicacionesLatLong", pm)) {
                statement.execute(
                        "INSERT INTO \"UbicacionesLatLong\" " +
                            "VALUES (" + pm.getIdelem() + ", " + resultConverted[0] +
                            ", " + resultConverted[1] + ");");
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ha sido insertado en la BD: UbicacionesLatLong");
            }
            else {
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ya se encontraba en la BD: UbicacionesLatLong");
            }

            //Comprobamos si está ya en la BD PuntosDeMedicion
            if (!this.checkIfExists("PuntosDeMedicion", pm)) {
                statement.execute(
                        "INSERT INTO \"PuntosDeMedicion\" " +
                            "VALUES (" + pm.getIdelem() + ", '" + pm.getDescripcion() + "', " +
                            pm.getIntensidad() + ", " + pm.getCarga() + ", " +
                            pm.getNivelServicio() + ", '" + pm.getFechaActualizacion() + "');");
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ha sido insertado en la BD: PuntosDeMedicion");
            }
            else {
                System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " ya se encontraba en la BD: PuntosDeMedicion");
            }

            query = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    private boolean checkIfExists(String database, TraficoPuntoDeMedicion pm) {

        boolean query = false;
        try {
            Statement statement = conn.createStatement();
            if (database.equals("PuntosDeMedicion")) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                            "(SELECT * FROM \"" + database + "\" " +
                            "WHERE idelem = " + pm.getIdelem() + " " +
                            "AND fecha_actualizacion = '" + pm.getFechaActualizacion() + "');");
                while (resultSet.next()) {
                    query = resultSet.getBoolean("exists");
                }
            }
            else if (database.equals("UbicacionesLatLong")) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                            "(SELECT * FROM \"" + database + "\" " +
                            "WHERE idelem = " + pm.getIdelem() + ");");
                while (resultSet.next()) {
                    query = resultSet.getBoolean("exists");
                }
            }
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;

    }

}
