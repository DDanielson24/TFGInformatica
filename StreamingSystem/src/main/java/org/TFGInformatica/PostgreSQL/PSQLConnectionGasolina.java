package org.TFGInformatica.PostgreSQL;

import org.TFGInformatica.EstacionDeServicio;

import java.sql.*;

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
        if (this.checkIfExists(es)) { //UPDATE

            try {
                Statement statement = conn.createStatement();
                //Actualizamos los valores del precio de la gasolina
                this.actualizarGasolina95(es);
                this.actualizarGasolina98(es);
                this.actualizarGasoleoA(es);
                this.actualizarGasoleoPremium(es);
                this.actualizarPrecioMedioCarburante(es);
                System.out.println("EstacionDeServicio: " + es.getRotulo() + ", " + es.getDireccion() +
                                   ", " + ", " + es.getMunicipio() + " ha sido actualizado en la BD");
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
                        "INSERT INTO \"UbicacionesLatLong\" " +
                                "VALUES (" + es.getIdelem() + ", " + es.getLatitud() +
                                ", " + es.getLongitud() + ");");
                System.out.println("EstacionDeServicio: " + es.getRotulo() + ", " + es.getDireccion() +
                       ", " + es.getMunicipio() + " ha sido insertado en la BD: UbicacionesLatLong");
                statement.execute(
                        "INSERT INTO \"EstacionesDeServicio\" (idelem, rotulo, direccion, " +
                                "municipio, fecha_actualizacion) " +
                                "VALUES (" + es.getIdelem() + ", '" + es.getRotulo() +
                                "', '" + es.getDireccion() + "', '" + es.getMunicipio() +
                                "', '" + es.getFechaActualizacion() + "');");
                //Actualizamos los valores del precio de la gasolina
                this.actualizarGasolina95(es);
                this.actualizarGasolina98(es);
                this.actualizarGasoleoA(es);
                this.actualizarGasoleoPremium(es);
                this.actualizarPrecioMedioCarburante(es);
                System.out.println("EstacionDeServicio: " + es.getRotulo() + ", " + es.getDireccion() +
                        ", " + ", " + es.getMunicipio() + " ha sido insertado en la BD: EstacionesDeServicio");
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
                        "'AND municipio = '" + es.getMunicipio() + "');");
            while (resultSet.next()) {
                query = resultSet.getBoolean("exists");
            }
            return query;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;

    }

    private void actualizarGasolina95 (EstacionDeServicio es) {
        Float precioGasolina95 = es.getPrecioGasolina95();
        try {
            Statement statement = conn.createStatement();
            if (precioGasolina95.equals(0f)) {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasolina_95 = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
            else {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasolina_95 = " + precioGasolina95 + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarGasolina98 (EstacionDeServicio es) {
        Float precioGasolina98 = es.getPrecioGasolina98();
        try {
            Statement statement = conn.createStatement();
            if (precioGasolina98.equals(0f)) {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasolina_98 = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
            else {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasolina_98 = " + precioGasolina98 + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarGasoleoA (EstacionDeServicio es) {
        Float precioGasoleoA = es.getPrecioGasoleoA();
        try {
            Statement statement = conn.createStatement();
            if (precioGasoleoA.equals(0f)) {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasoleo_a = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
            else {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasoleo_a = " + precioGasoleoA + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarGasoleoPremium (EstacionDeServicio es) {
        Float precioGasoleoPremium = es.getPrecioGasoleoPremium();
        try {
            Statement statement = conn.createStatement();
            if (precioGasoleoPremium.equals(0f)) {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasoleo_premium = NULL " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
            else {
                statement.execute(
                            "UPDATE \"EstacionesDeServicio\" " +
                                "SET precio_gasoleo_premium = " + precioGasoleoPremium + " " +
                                "WHERE idelem = " + es.getIdelem() + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarPrecioMedioCarburante (EstacionDeServicio es) {
        int tiposCarburanteOfertados = 0;
        float suma_precio_carburante = 0f;
        Float precioGasolina95 = es.getPrecioGasolina95();
        Float precioGasolina98 = es.getPrecioGasolina98();
        Float precioGasoleoA = es.getPrecioGasoleoA();
        Float precioGasoleoPremium = es.getPrecioGasoleoPremium();

        //Comprobamos los tipos de carburantes ofertados, es decir, aquellos que no tienen valor 0
        if (!precioGasolina95.equals(0f)) {
            tiposCarburanteOfertados++;
            suma_precio_carburante = suma_precio_carburante + precioGasolina95;
        }
        if (!precioGasolina98.equals(0f)) {
            tiposCarburanteOfertados++;
            suma_precio_carburante = suma_precio_carburante + precioGasolina98;
        }
        if (!precioGasoleoA.equals(0f)) {
            tiposCarburanteOfertados++;
            suma_precio_carburante = suma_precio_carburante + precioGasoleoA;
        }
        if (!precioGasoleoPremium.equals(0f)) {
            tiposCarburanteOfertados++;
            suma_precio_carburante = suma_precio_carburante + precioGasoleoPremium;
        }

        float precio_medio_carburante = 0f;
        if (tiposCarburanteOfertados != 0) {
            precio_medio_carburante = suma_precio_carburante / tiposCarburanteOfertados;
        }

        //Insertamos el valor promedio en la base de datos
        try {
            Statement statement = conn.createStatement();
            statement.execute(
                    "UPDATE \"EstacionesDeServicio\" " +
                    "SET precio_medio_carburante = " + precio_medio_carburante + " " +
                    "WHERE idelem = " + es.getIdelem() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
