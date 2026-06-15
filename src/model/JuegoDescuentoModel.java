package model;

public class JuegoDescuentoModel {
    private int id_juego_descuento;
    private int id_juego;
    private int id_descuento;

    public JuegoDescuentoModel(int id_juego_descuento, int id_juego, int id_descuento) {
        this.id_juego_descuento = id_juego_descuento;
        this.id_juego = id_juego;
        this.id_descuento = id_descuento;
    }

    public int getId_juego_descuento() {
        return id_juego_descuento;
    }

    public void setId_juego_descuento(int id_juego_descuento) {
        this.id_juego_descuento = id_juego_descuento;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }
}
