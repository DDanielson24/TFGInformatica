package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.ContaminacionEstacionDeMedicion;
import org.TFGInformatica.TraficoPuntoDeMedicion;

import java.sql.*;

public class PSQLConnectionContaminacion {

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

    public boolean addRow(ContaminacionEstacionDeMedicion em) {
        boolean query = false;
        try {
            Statement statement = conn.createStatement();
            //Comprobamos si está ya en la BD EstacionesDeMedicion
            if (!this.checkIfExists(em)) {
                statement.execute(
                        "INSERT INTO \"EstacionesDeMedicion\" " +
                            "VALUES (" + em.getIdelem() + ", '" + em.getDescripcion() + "', " +
                            em.getNo() + ", " + em.getNo2() + ", " + em.getPm25() + ", " +
                            em.getPm10() + ", " + em.getNox() + ", " + em.getO3() + ", '" +
                            em.getFechaActualizacion() + "');");
                System.out.println("EstacionDeMedicion: " + em.getIdelem() + " ha sido insertado en la BD: EstacionesDeMedicion");
            }
            else {
                System.out.println("EstacionDeMedicion: " + em.getIdelem() + " ya se encontraba en la BD: EstacionesDeMedicion");
            }
            query = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    private boolean checkIfExists(ContaminacionEstacionDeMedicion em) {
        boolean query = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT EXISTS " +
                            "(SELECT * FROM \"EstacionesDeMedicion\" " +
                            "WHERE idelem = " + em.getIdelem() + " " +
                            "AND fecha_actualizacion = '" + em.getFechaActualizacion() + "');");
            while (resultSet.next()) {
                query = resultSet.getBoolean("exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
