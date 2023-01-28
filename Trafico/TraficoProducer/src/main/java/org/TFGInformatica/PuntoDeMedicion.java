package org.TFGInformatica;

public class PuntoDeMedicion {

    private Integer idelem;
    private String descripcion;
    private Integer carga;
    private Integer nivelServicio;
    private String error;
    private Float st_x;
    private Float st_y;

    public PuntoDeMedicion () {}

    public Integer getIdelem() {
        return idelem;
    }

    public void setIdelem(String idelem) {
        this.idelem = Integer.parseInt(idelem);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = Integer.parseInt(carga);
    }

    public Integer getNivelServicio() {
        return nivelServicio;
    }

    public void setNivelServicio(String nivelServicio) {
        this.nivelServicio = Integer.parseInt(nivelServicio);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Float getSt_x() {
        return st_x;
    }

    public void setSt_x(String st_x) {
        String st_x_1 = st_x.substring(0, st_x.indexOf(','));
        String st_x_2 = st_x.substring(st_x.indexOf(',') + 1, st_x.length());
        String st_x_final = st_x_1 + "." + st_x_2;
        this.st_x = Float.parseFloat(st_x_final);
    }

    public Float getSt_y() {
        return st_y;
    }

    public void setSt_y(String st_y) {
        String st_y_1 = st_y.substring(0, st_y.indexOf(','));
        String st_y_2 = st_y.substring(st_y.indexOf(',') + 1, st_y.length());
        String st_y_final = st_y_1 + "." + st_y_2;
        this.st_y = Float.parseFloat(st_y_final);
    }
}
