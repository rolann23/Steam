package model;

public class DesarrolladorModel {
    private int id_desarrollador;
    private String nombre_desarrollador;
    private String imagenD_url;
    private String descripcionD;

    public DesarrolladorModel(int id_desarrollador, String nombre_desarrollador, String imagenD_url, String descripcionD) {
        this.id_desarrollador = id_desarrollador;
        this.nombre_desarrollador = nombre_desarrollador;
        this.imagenD_url = imagenD_url;
        this.descripcionD = descripcionD;
    }

    public int getId_desarrollador() {
        return id_desarrollador;
    }

    public void setId_desarrollador(int id_desarrollador) {
        this.id_desarrollador = id_desarrollador;
    }

    public String getNombre_desarrollador() {
        return nombre_desarrollador;
    }

    public void setNombre_desarrollador(String nombre_desarrollador) {
        this.nombre_desarrollador = nombre_desarrollador;
    }

    public String getImagenD_url() {
        return imagenD_url;
    }

    public void setImagenD_url(String imagenD_url) {
        this.imagenD_url = imagenD_url;
    }

    public String getDescripcionD() {
        return descripcionD;
    }

    public void setDescripcionD(String descripcionD) {
        this.descripcionD = descripcionD;
    }
}
