package model;

public class PaisesModel {
    private int id_pais;
    private String nombre_pais;
    private String codigo_iso;
    private String moneda_codigo;
    private String simbolo_moneda;

    public PaisesModel(int id_pais, String nombre_pais, String codigo_iso, String moneda_codigo, String simbolo_moneda) {
        this.id_pais = id_pais;
        this.nombre_pais = nombre_pais;
        this.codigo_iso = codigo_iso;
        this.moneda_codigo = moneda_codigo;
        this.simbolo_moneda = simbolo_moneda;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getCodigo_iso() {
        return codigo_iso;
    }

    public void setCodigo_iso(String codigo_iso) {
        this.codigo_iso = codigo_iso;
    }

    public String getMoneda_codigo() {
        return moneda_codigo;
    }

    public void setMoneda_codigo(String moneda_codigo) {
        this.moneda_codigo = moneda_codigo;
    }

    public String getSimbolo_moneda() {
        return simbolo_moneda;
    }

    public void setSimbolo_moneda(String simbolo_moneda) {
        this.simbolo_moneda = simbolo_moneda;
    }
}
