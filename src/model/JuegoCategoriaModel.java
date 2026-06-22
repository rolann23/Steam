package model;

public class JuegoCategoriaModel {
    private int id_juego;
    private int id_categoria;

    public JuegoCategoriaModel(int id_juego, int id_categoria) {
        this.id_juego = id_juego;
        this.id_categoria = id_categoria;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
