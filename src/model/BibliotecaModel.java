package model;

import java.sql.Date;

public class BibliotecaModel {
    private int id_biblioteca;
    private int id_usuario;
    private int id_juego;
    private Date fecha_adquirido;
    private int horas_jugadas;

    public BibliotecaModel(int id_biblioteca, int id_usuario, int id_juego, Date fecha_adquirido, int horas_jugadas) {
        this.id_biblioteca = id_biblioteca;
        this.id_usuario = id_usuario;
        this.id_juego = id_juego;
        this.fecha_adquirido = fecha_adquirido;
        this.horas_jugadas = horas_jugadas;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
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

    public Date getFecha_adquirido() {
        return fecha_adquirido;
    }

    public void setFecha_adquirido(Date fecha_adquirido) {
        this.fecha_adquirido = fecha_adquirido;
    }

    public int getHoras_jugadas() {
        return horas_jugadas;
    }

    public void setHoras_jugadas(int horas_jugadas) {
        this.horas_jugadas = horas_jugadas;
    }
}
