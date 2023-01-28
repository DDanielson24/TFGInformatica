package org.TFGInformatica;

public class PuntoDeMedicion {

    private Integer idelem;
    private String descripcion;
    private Integer carga;
    private Integer nivelServicio;
    private String error;
    private Float st_x;
    private Float st_y;

    public PuntoDeMedicion (Integer idelem, String descripcion, Integer carga, Integer nivelServicio, String error, Float st_x, Float st_y) {
        this.idelem = idelem;
        this.descripcion = descripcion;
        this.carga = carga;
        this.nivelServicio = nivelServicio;
        this.error = error;
        this.st_x = st_x;
        this.st_y = st_y;
    }

    public Integer getIdelem() {
        return idelem;
    }

    public void setIdelem(Integer idelem) {
        this.idelem = idelem;
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

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public Integer getNivelServicio() {
        return nivelServicio;
    }

    public void setNivelServicio(Integer nivelServicio) {
        this.nivelServicio = nivelServicio;
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

    public void setSt_x(Float st_x) {
        this.st_x = st_x;
    }

    public Float getSt_y() {
        return st_y;
    }

    public void setSt_y(Float st_y) {
        this.st_y = st_y;
    }
}
