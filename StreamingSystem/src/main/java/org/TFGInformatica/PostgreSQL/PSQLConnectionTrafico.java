package org.TFGInformatica.PostgreSQL;

import java.sql.*;

public class PSQLConnectionTrafico {

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DATABASE = "TraficoData";
    private final String USER = "fdaniel";
    private final String PASSWORD = "TFGInformatica";
    private String url = "jdbc:postgresql://" + HOST + ":" + PUERTO + "/" + DATABASE;
    private Connection conn = null;

    public Connection connect() {
        try {

            conn = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Se ha conectado exitosamente a la BD: " + DATABASE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }



}
