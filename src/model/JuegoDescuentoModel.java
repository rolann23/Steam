package model;

public class JuegoDescuentoModel {
    private int id_juego;
    private int id_campana;
    private int id_pais;
    private int porcentaje_descuento;

    public JuegoDescuentoModel(int id_juego, int id_campana, int id_pais, int porcentaje_descuento) {

        this.id_juego = id_juego;
        this.id_campana = id_campana;
        this.id_pais = id_pais;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_campana() {
        return id_campana;
    }

    public void setId_campana(int id_campana) {
        this.id_campana = id_campana;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(int porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }
}
