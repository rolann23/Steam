package model;

import java.sql.Date;

public class Usuarios_JuegosModel {
    private int id_usuario;
    private int id_juego;
    private Date fecha_ultimo_juego;
    private float horas_jugadas;
    private String estado;

    public Usuarios_JuegosModel(int id_usuario, int id_juego, Date fecha_ultimo_juego, float horas_jugadas, String estado) {
        this.id_usuario = id_usuario;
        this.id_juego = id_juego;
        this.fecha_ultimo_juego = fecha_ultimo_juego;
        this.horas_jugadas = horas_jugadas;
        this.estado = estado;
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

    public Date getFecha_ultimo_juego() {
        return fecha_ultimo_juego;
    }

    public void setFecha_ultimo_juego(Date fecha_ultimo_juego) {
        this.fecha_ultimo_juego = fecha_ultimo_juego;
    }

    public float getHoras_jugadas() {
        return horas_jugadas;
    }

    public void setHoras_jugadas(float horas_jugadas) {
        this.horas_jugadas = horas_jugadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
