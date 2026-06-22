package model;

public class DetalleCompraModel {
    private int id_detalle;
    private int id_compra;
    private int id_juego;
    private float precio_unitario;
    private int porcentaje_descuento_aplicado;

    public DetalleCompraModel(int id_detalle, int id_compra, int id_juego, float precio_unitario, int porcentaje_descuento_aplicado) {
        this.id_detalle = id_detalle;
        this.id_compra = id_compra;
        this.id_juego = id_juego;
        this.precio_unitario = precio_unitario;
        this.porcentaje_descuento_aplicado = porcentaje_descuento_aplicado;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getPorcentaje_descuento_aplicado() {
        return porcentaje_descuento_aplicado;
    }

    public void setPorcentaje_descuento_aplicado(int porcentaje_descuento_aplicado) {
        this.porcentaje_descuento_aplicado = porcentaje_descuento_aplicado;
    }
}
