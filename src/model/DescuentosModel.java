package model;

import java.sql.Date;

public class DescuentosModel {
    private int id_descuento;
    private int id_juego;
    private float porcentaje;
    private Date fecha_inicio;
    private Date fecha_fin;

    public DescuentosModel(int id_descuento, int id_juego, float porcentaje, Date fecha_inicio, Date fecha_fin) {
        this.id_descuento = id_descuento;
        this.id_juego = id_juego;
        this.porcentaje = porcentaje;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
