package model;

import java.sql.Date;

public class ResenasModel {
    private int id_resena;
    private int id_usuario;
    private int id_juego;
    private boolean recomendado;
    private String contenido;
    private Date fecha_resena;

    public ResenasModel(int id_resena, int id_usuario, int id_juego, boolean recomendado, String contenido, Date fecha_resena) {
        this.id_resena = id_resena;
        this.id_usuario = id_usuario;
        this.id_juego = id_juego;
        this.recomendado = recomendado;
        this.contenido = contenido;
        this.fecha_resena = fecha_resena;
    }

    public int getId_resena() {
        return id_resena;
    }

    public void setId_resena(int id_resena) {
        this.id_resena = id_resena;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_resena() {
        return fecha_resena;
    }

    public void setFecha_resena(Date fecha_resena) {
        this.fecha_resena = fecha_resena;
    }
}
