package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.EstacionDeServicio;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PSQLConnectionGasolina {

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

    public boolean addRow(EstacionDeServicio es) {

        boolean query = false;

        try {
            Statement statement = conn.createStatement();

            //Comprobamos si está ya en la BD UbicacionesLatLong
            if (!this.checkIfExists("UbicacionesLatLong", es)) {
                statement.execute(
                        "INSERT INTO \"UbicacionesLatLong\" " +
                                "VALUES (" + es.getIdelem() + ", " + es.getLatitud() +
                                ", " + es.getLongitud() + ");");
                System.out.println("EstacionesDeServicio: " + es.getIdelem() + " ha sido insertado en la BD: UbicacionesLatLong");
            }
            else {
                System.out.println("EstacionesDeServicio: " + es.getIdelem() + " ya se encontraba en la BD: UbicacionesLatLong");
            }

            //Comprobamos si está ya en la BD EstacionesDeServicioHistorico
            if (!this.checkIfExists("EstacionesDeServicioHistorico", es)) {
                statement.execute(
                        "INSERT INTO \"EstacionesDeServicioHistorico\" (idelem, rotulo, direccion, " +
                            "municipio, fecha_actualizacion) " +
                            "VALUES (" + es.getIdelem() + ", '" + es.getRotulo() +
                            "', '" + es.getDireccion() + "', '" + es.getMunicipio() +
                            "', '" + es.getFechaActualizacion() + "');");
                //Actualizamos los valores del precio de la gasolina
                this.actualizarGasolina95("EstacionesDeServicioHistorico", es);
                this.actualizarGasolina98("EstacionesDeServicioHistorico", es);
                this.actualizarGasoleoA("EstacionesDeServicioHistorico", es);
                this.actualizarGasoleoPremium("EstacionesDeServicioHistorico", es);
                System.out.println("EstacionesDeServicio: " + es.getIdelem() + " ha sido insertado en la BD: EstacionesDeServicioHistorico");
            }
            else {
                System.out.println("EstacionesDeServicio: " + es.getIdelem() + " ya se encontraba en la BD: EstacionesDeServicioHistorico");
            }

            //Comprobamos si está ya en la BD EstacionesDeServicio
            if (!this.checkIfExists("EstacionesDeServicio", es)) {
                statement.execute(
                        "INSERT INTO \"EstacionesDeServicio\" (idelem, rotulo, direccion, " +
                            "municipio, fecha_actualizacion) " +
                            "VALUES (" + es.getIdelem() + ", '" + es.getRotulo() +
                            "', '" + es.getDireccion() + "', '" + es.getMunicipio() +
                            "', '" + es.getFechaActualizacion() + "');");
                //Actualizamos los valores del precio de la gasolina
                this.actualizarGasolina95("EstacionesDeServicio", es);
                this.actualizarGasolina98("EstacionesDeServicio", es);
                this.actualizarGasoleoA("EstacionesDeServicio", es);
                this.actualizarGasoleoPremium("EstacionesDeServicio", es);
                System.out.println("EstacionesDeServicio: " + es.getIdelem() + " ha sido actualizado en la BD: EstacionesDeServicio");
            }
            else {
                //Actualizamos los valores del precio de la gasolina y la fecha de actualizacion
                statement.execute(
                        "UPDATE \"EstacionesDeServicio\" " +
                            "SET fecha_actualizacion = '" + es.getFechaActualizacion() + "' " +
                            "WHERE idelem = " + es.getIdelem() + ";");
                this.actualizarGasolina95("EstacionesDeServicio", es);
                this.actualizarGasolina98("EstacionesDeServicio", es);
                this.actualizarGasoleoA("EstacionesDeServicio", es);
                this.actualizarGasoleoPremium("EstacionesDeServicio", es);
                System.out.println("EstacionesDeServicio: " + es.getIdelem() + " ha sido actualizado en la BD: EstacionesDeServicio");
            }
            query = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    private boolean checkIfExists(String database, EstacionDeServicio es) {

        boolean query = false;
        try {

            Statement statement = conn.createStatement();

            if (database.equals("EstacionesDeServicio")) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                            "(SELECT * FROM \"" + database + "\" " +
                            "WHERE idelem = " + es.getIdelem() + ");");
                while (resultSet.next()) {
                    query = resultSet.getBoolean("exists");
                }
            }
            else if (database.equals("EstacionesDeServicioHistorico")) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                            "(SELECT * FROM \"" + database + "\" " +
                            "WHERE idelem = " + es.getIdelem() + " " +
                            "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "');");
                while (resultSet.next()) {
                    query = resultSet.getBoolean("exists");
                }
            }
            else if (database.equals("UbicacionesLatLong")) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT EXISTS " +
                            "(SELECT * FROM \"" + database + "\" " +
                            "WHERE idelem = " + es.getIdelem() + ");");
                while (resultSet.next()) {
                    query = resultSet.getBoolean("exists");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;

    }

    private void actualizarGasolina95 (String database, EstacionDeServicio es) {
        Float precioGasolina95 = es.getPrecioGasolina95();
        try {
            Statement statement = conn.createStatement();

            if (database.equals("EstacionesDeServicioHistorico")) {
                if (precioGasolina95.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_95 = NULL " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_95 = " + precioGasolina95 + " " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
            }
            else if (database.equals("EstacionesDeServicio")) {
                if (precioGasolina95.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_95 = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_95 = " + precioGasolina95 + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarGasolina98 (String database, EstacionDeServicio es) {
        Float precioGasolina98 = es.getPrecioGasolina98();
        try {
            Statement statement = conn.createStatement();

            if (database.equals("EstacionesDeServicioHistorico")) {
                if (precioGasolina98.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_98 = NULL " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_98 = " + precioGasolina98 + " " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
            }
            else if (database.equals("EstacionesDeServicio")) {
                if (precioGasolina98.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_98 = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasolina_98 = " + precioGasolina98 + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarGasoleoA (String database, EstacionDeServicio es) {
        Float precioGasoleoA = es.getPrecioGasoleoA();
        try {
            Statement statement = conn.createStatement();

            if (database.equals("EstacionesDeServicioHistorico")) {
                if (precioGasoleoA.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_a = NULL " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_a = " + precioGasoleoA + " " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
            }
            else if (database.equals("EstacionesDeServicio")) {
                if (precioGasoleoA.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_a = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_a = " + precioGasoleoA + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarGasoleoPremium (String database, EstacionDeServicio es) {
        Float precioGasoleoPremium = es.getPrecioGasoleoPremium();
        try {
            Statement statement = conn.createStatement();

            if (database.equals("EstacionesDeServicioHistorico")) {
                if (precioGasoleoPremium.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_premium = NULL " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_premium = " + precioGasoleoPremium + " " +
                                "WHERE idelem = " + es.getIdelem() + " " +
                                "AND fecha_actualizacion = '" + es.getFechaActualizacion() + "';");
                }
            }
            else if (database.equals("EstacionesDeServicio")) {
                if (precioGasoleoPremium.equals(0f)) {
                    statement.execute(
                            "UPDATE \"" + database + "\" " +
                                "SET precio_gasoleo_premium = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
                else {
                    statement.execute(
                            "UPDATE \"" + database + "\"" +
                                "SET precio_gasoleo_premium = " + precioGasoleoPremium + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
