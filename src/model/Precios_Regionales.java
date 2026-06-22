package model;

public class Precios_Regionales {
    private int id_juego;
    private int id_pais;
    private float precio;

    public Precios_Regionales(int id_juego, int id_pais, float precio) {
        this.id_juego = id_juego;
        this.id_pais = id_pais;
        this.precio = precio;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
