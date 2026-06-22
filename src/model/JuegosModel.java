package model;

import java.sql.Date;

public class JuegosModel {
    private int id_juego;
    private int id_editor;
    private int id_desarrollador;
    private String titulo;
    private String descripcion;
    private String portada_url;
    private Date fecha_lanzamiento;

    public JuegosModel(int id_juego, int id_editor, int id_desarrollador, String titulo, String descripcion, String portada_url, Date fecha_lanzamiento) {
        this.id_juego = id_juego;
        this.id_editor = id_editor;
        this.id_desarrollador = id_desarrollador;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.portada_url = portada_url;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_editor() {
        return id_editor;
    }

    public void setId_editor(int id_editor) {
        this.id_editor = id_editor;
    }

    public int getId_desarrollador() {
        return id_desarrollador;
    }

    public void setId_desarrollador(int id_desarrollador) {
        this.id_desarrollador = id_desarrollador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortada_url() {
        return portada_url;
    }

    public void setPortada_url(String portada_url) {
        this.portada_url = portada_url;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }
}
