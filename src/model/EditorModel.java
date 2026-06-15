package model;

public class EditorModel {
    private int id_editor;
    private int id_juego;
    private String nombre_editor;
    private String imagenE_url;
    private String descripcionE;

    public EditorModel(int id_editor, int id_juego, String nombre_editor, String imagenE_url, String descripcionE) {
        this.id_editor = id_editor;
        this.id_juego = id_juego;
        this.nombre_editor = nombre_editor;
        this.imagenE_url = imagenE_url;
        this.descripcionE = descripcionE;
    }

    public int getId_editor() {
        return id_editor;
    }

    public void setId_editor(int id_editor) {
        this.id_editor = id_editor;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public String getNombre_editor() {
        return nombre_editor;
    }

    public void setNombre_editor(String nombre_editor) {
        this.nombre_editor = nombre_editor;
    }

    public String getImagenE_url() {
        return imagenE_url;
    }

    public void setImagenE_url(String imagenE_url) {
        this.imagenE_url = imagenE_url;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
}
