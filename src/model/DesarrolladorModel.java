package model;

public class DesarrolladorModel {
    private int id_desarrollador;
    private int id_juego;
    private String nombre_desarrollador;
    private String imagenD_url;
    private String descripcionD;

    public DesarrolladorModel(int id_desarrollador, int id_juego, String nombre_desarrollador, String imagenD_url, String descripcionD) {
        this.id_desarrollador = id_desarrollador;
        this.id_juego = id_juego;
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

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
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
