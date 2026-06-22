package model;

import java.sql.Date;

public class Lista_deseosModel {
    private int id_usuario;
    private int id_juego;
    private Date fechaa_agregado;

    public Lista_deseosModel(int id_usuario, int id_juego, Date fechaa_agregado) {
        this.id_usuario = id_usuario;
        this.id_juego = id_juego;
        this.fechaa_agregado = fechaa_agregado;
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

    public Date getFechaa_agregado() {
        return fechaa_agregado;
    }

    public void setFechaa_agregado(Date fechaa_agregado) {
        this.fechaa_agregado = fechaa_agregado;
    }
}
