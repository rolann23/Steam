package model;

import java.sql.Date;

public class ComprasModel {
    private int id_compra;
    private int id_usuario;
    private int id_metodo;
    private float total;
    private Date fecha_compra;

    public ComprasModel(int id_compra, int id_usuario, int id_metodo, float total, Date fecha_compra) {
        this.id_compra = id_compra;
        this.id_usuario = id_usuario;
        this.id_metodo = id_metodo;
        this.total = total;
        this.fecha_compra = fecha_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_metodo() {
        return id_metodo;
    }

    public void setId_metodo(int id_metodo) {
        this.id_metodo = id_metodo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
}
