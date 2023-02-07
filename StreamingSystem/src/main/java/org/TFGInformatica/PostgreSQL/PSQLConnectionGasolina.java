package org.TFGInformatica.PostgreSQL;

import java.sql.*;

public class PSQLConnectionGasolina {

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DATABASE = "GasolinaData";
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
}
