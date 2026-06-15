package model;

import java.sql.Date;

public class JuegosModel {
    private int id_juego;
    private int id_categoria;
    private String titulo;
    private String descripcion;
    private float precio_base;
    private String portada_url;
    private Date fecha_lanzamiento;

    public JuegosModel(int id_juego, int id_categoria, String titulo, String descripcion, float precio_base, String portada_url, Date fecha_lanzamiento) {
        this.id_juego = id_juego;
        this.id_categoria = id_categoria;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio_base = precio_base;
        this.portada_url = portada_url;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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

    public float getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(float precio_base) {
        this.precio_base = precio_base;
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
