package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.Trafico.PuntoDeMedicion;

import javax.xml.transform.Result;
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

    public boolean addRow(PuntoDeMedicion pm) {

        boolean query = false;

        if (this.checkIfExists(pm)) { //UPDATE

            try {

                Statement statement = conn.createStatement();
                statement.execute(
                        "UPDATE \"PuntosDeMedicion\" " +
                        "SET carga = " + pm.getCarga() + ", " +
                            "nivel_servicio = " + pm.getNivelServicio() + " " +
                        "WHERE idelem = " + pm.getIdelem() + ";");
                System.out.println("exito");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return query;

        }
        else { //INSERT



        }

        return query;

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
