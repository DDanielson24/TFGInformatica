package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.EstacionDeServicio;

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

    public boolean addRow(EstacionDeServicio es) {

        boolean query = false;
        if (this.checkIfExists(es)) { //UPDATE

            try {
                Statement statement = conn.createStatement();
                statement.execute(
                        "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasolina_95 = " + es.getPrecioGasolina95() + ", " +
                                    "precio_gasolina_98 = " + es.getPrecioGasolina98() + ", " +
                                    "precio_gasoleo_a = " + es.getPrecioGasoleoA() + ", " +
                                    "precio_gasoleo_premium = " + es.getPrecioGasoleoPremium() + " " +
                                "WHERE rotulo = '" + es.getRotulo() + "' AND direccion = '" + es.getDireccion() +
                                "' AND municipio = '" + es.getMunicipio() + "';");
                System.out.println("EstacionDeServicio: " + es.getRotulo() + ", " + es.getDireccion() +
                                   ", " + es.getMargen() + ", " + es.getMunicipio() + " ha sido actualizado en la BD");
                query = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return query;

        }
        else { //INSERT

            try {
                Statement statement = conn.createStatement();
                statement.execute(
                        "INSERT INTO \"EstacionesDeServicio\" " +
                                "VALUES ('" + es.getRotulo() + "', '" + es.getDireccion() + "', '" +
                                es.getMargen() + "', '" + es.getMunicipio() +
                                "', " + es.getCodigoPostal() + ", " + es.getPrecioGasolina95() +
                                ", " + es.getPrecioGasolina98() + ", " + es.getPrecioGasoleoA() +
                                ", " + es.getPrecioGasoleoPremium() + ", " + es.getLatitud() +
                                ", " + es.getLongitud() +");");
                System.out.println("EstacionDeServicio: " + es.getRotulo() + ", " + es.getDireccion() +
                        ", " + es.getMargen() + ", " + es.getMunicipio() + " ha sido insertado en la BD");
                query = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return query;
        }
    }

    private boolean checkIfExists(EstacionDeServicio es) {

        boolean query = false;
        try {

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT EXISTS" +
                        "(SELECT * FROM \"EstacionesDeServicio\" " +
                        "WHERE rotulo = '" + es.getRotulo() + "' AND direccion = '" + es.getDireccion() +
                        "' AND margen = '" + es.getMargen() + "'AND municipio = '" + es.getMunicipio() + "');");
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
