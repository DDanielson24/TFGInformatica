package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.Trafico.PuntoDeMedicion;

import java.sql.*;

public class PSQLConnectionTrafico {

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DATABASE = "TraficoData";
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

    public boolean checkExists(PuntoDeMedicion pm) {
        try {

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
