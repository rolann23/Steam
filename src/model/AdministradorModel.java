package model;

import java.sql.Date;

public class AdministradorModel {
    private int id_admin;
    private int id_usuario;
    private String nivel_acceso;
    private Date fecha_asignacion;

    public AdministradorModel(int id_admin, int id_usuario, String nivel_acceso, Date fecha_asignacion) {
        this.id_admin = id_admin;
        this.id_usuario = id_usuario;
        this.nivel_acceso = nivel_acceso;
        this.fecha_asignacion = fecha_asignacion;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(String nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }
}
