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

    public boolean addRow(ContaminacionEstacionDeMedicion em) {

        boolean query = false;

        try {
            Statement statement = conn.createStatement();

            //Comprobamos si está ya en la BD EstacionesDeMedicion
            if (!this.checkIfExists("EstacionesDeMedicionHistorico", em)) {
                statement.execute(
                        "INSERT INTO \"EstacionesDeMedicionHistorico\" " +
                            "VALUES (" + em.getIdelem() + ", '" + em.getDescripcion() + "', " +
                            em.getSo2() + ", " + em.getCo() + ", " + em.getNo() + ", " +
                            em.getNo2() + ", " + em.getPm25() + ", " + em.getPm10() + ", " +
                            em.getNox() + ", " + em.getO3() + ", " + em.getTol() + ", " +
                            em.getBen() + ", " + em.getEbe() + ", '" + em.getFechaActualizacion() + "');");
                System.out.println("EstacionDeMedicion: " + em.getIdelem() + " ha sido insertado en la BD: EstacionesDeMedicionHistorico");
            }
            else {
                System.out.println("EstacionDeMedicion: " + em.getIdelem() + " ya se encontraba en la BD: EstacionesDeMedicionHistorico");
            }

            //Comprobamos si está ya en la BD PuntosDeMedicion
            if (!this.checkIfExists("EstacionesDeMedicion", em)) {
                statement.execute(
                        "INSERT INTO \"EstacionesDeMedicion\" " +
                            "VALUES (" + em.getIdelem() + ", '" + em.getDescripcion() + "', " +
                            em.getSo2() + ", " + em.getCo() + ", " + em.getNo() + ", " +
                            em.getNo2() + ", " + em.getPm25() + ", " + em.getPm10() + ", " +
                            em.getNox() + ", " + em.getO3() + ", " + em.getTol() + ", " +
                            em.getBen() + ", " + em.getEbe() + ", '" + em.getFechaActualizacion() + "');");
                System.out.println("EstacionDeMedicion: " + em.getIdelem() + " ha sido actualizado en la BD: EstacionesDeMedicion");
            }
            else {
                statement.execute(
                        "UPDATE \"EstacionesDeMedicion\" " +
                            "SET dioxido_de_azufre = " + em.getSo2() + ", monoxido_de_carbono = " + em.getCo() + ", monoxido_de_nitrogeno = " + em.getNo() + ", " +
                            "dioxido_de_nitrogeno = " + em.getNo2() + ", particulas_2_5 = " + em.getPm25() + ", particulas_10 = " + em.getPm10() + ", " +
                            "oxidos_de_nitrogeno = " + em.getNox() + ", ozono = " + em.getO3() + ", tolueno = " + em.getTol() + ", " +
                            "benceno = " + em.getBen() + ", etilbenceno = " + em.getEbe() + ", fecha_actualizacion = '" + em.getFechaActualizacion() + "' " +
                            "WHERE idelem = " + em.getIdelem() + ";");
                System.out.println("EstacionDeMedicion: " + em.getIdelem() + " ha sido actualizado en la BD: EstacionesDeMedicion");
            }
            query = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    private boolean checkIfExists(String database, ContaminacionEstacionDeMedicion em) {

        boolean query = false;
        try {
            if (database.equals("EstacionesDeMedicion")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                                "(SELECT * FROM \"" + database + "\" " +
                                "WHERE idelem = " + em.getIdelem() + ");");
                while (resultSet.next()) {
                    query = resultSet.getBoolean("exists");
                }
            }
            else if (database.equals("EstacionesDeMedicionHistorico")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                            "(SELECT * FROM \"" + database + "\" " +
                            "WHERE idelem = " + em.getIdelem() + " " +
                            "AND fecha_actualizacion = '" + em.getFechaActualizacion() + "');");
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
