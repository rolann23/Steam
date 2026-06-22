package model;

import java.sql.Date;

public class UsuariosModel {
    private int id_usuario;
    private int id_pais;
    private String nombre_usuario;
    private String correo;
    private String contrasena;
    private String avatar_url;
    private float saldo_billetera;
    private Date fecha_registro;

    public UsuariosModel(int id_usuario, int id_pais, String nombre_usuario, String correo, String contrasena, String avatar_url, float saldo_billetera, Date fecha_registro) {
        this.id_usuario = id_usuario;
        this.id_pais = id_pais;
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.avatar_url = avatar_url;
        this.saldo_billetera = saldo_billetera;
        this.fecha_registro = fecha_registro;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public float getSaldo_billetera() {
        return saldo_billetera;
    }

    public void setSaldo_billetera(float saldo_billetera) {
        this.saldo_billetera = saldo_billetera;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
