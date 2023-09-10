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
        try {
            Statement statement = conn.createStatement();
            //Comprobamos si está ya en la BD PuntosDeMedicion
            if (!this.checkIfExists(pm)) {
                statement.execute(
                        "INSERT INTO \"PuntosDeMedicion\" " +
                            "VALUES (" + pm.getIdelem() + ", '" + pm.getDescripcion() + "', " +
                            pm.getIntensidad() + ", " + pm.getCarga() + ", " +
                            pm.getNivelServicio() + ", " + pm.getDistrito() + ", '" +
                            pm.getFechaActualizacion() + "');");
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

    private boolean checkIfExists(TraficoPuntoDeMedicion pm) {
        boolean query = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT EXISTS " +
                        "(SELECT * FROM \"PuntosDeMedicion\" " +
                        "WHERE idelem = " + pm.getIdelem() + " " +
                        "AND fecha_actualizacion = '" + pm.getFechaActualizacion() + "');");
            while (resultSet.next()) {
                query = resultSet.getBoolean("exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

}
