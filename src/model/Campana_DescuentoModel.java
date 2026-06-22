package model;

import java.sql.Date;

public class Campana_DescuentoModel {
    private int id_descuento;
    private String nombre_campana;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Campana_DescuentoModel(int id_descuento, String nombre_campana, Date fecha_inicio, Date fecha_fin) {
        this.id_descuento = id_descuento;
        this.nombre_campana = nombre_campana;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getNombre_campana() {
        return nombre_campana;
    }

    public void setNombre_campana(String nombre_campana) {
        this.nombre_campana = nombre_campana;
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
