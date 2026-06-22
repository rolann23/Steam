package model;

public class Metodos_PagoModel {
    private int id_metodo;
    private String nombre;
    private String descripcion;

    public Metodos_PagoModel(int id_metodo, String nombre, String descripcion) {
        this.id_metodo = id_metodo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_metodo() {
        return id_metodo;
    }

    public void setId_metodo(int id_metodo) {
        this.id_metodo = id_metodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
