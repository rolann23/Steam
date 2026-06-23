package controller;

import model.UsuariosModel;
import services.DatabaseConnector;
import services.JuegosDAO;
import services.UsuariosDAO;
import services.UsuariosDAOImplementation;

import java.util.List;

public class UsuariosController {
    private UsuariosDAO usuariosDAO;

    public UsuariosController(DatabaseConnector databaseConnector) {
        this.usuariosDAO = new UsuariosDAOImplementation(databaseConnector);
    }

    public boolean registrar(UsuariosModel u) {
        return usuariosDAO.insertar(u);
    }

    public boolean actualizar(UsuariosModel u) {
        return usuariosDAO.actualizar(u);
    }

    public boolean eliminar(int id) {
        return usuariosDAO.eliminar(id);
    }

    public UsuariosModel buscar(int id) {
        return usuariosDAO.buscarPorId(id);
    }

    public List<UsuariosModel> listar() {
        return usuariosDAO.listarTodos();
    }

    public UsuariosModel login(String correo, String password) {
        return usuariosDAO.login(correo, password);
    }

    public boolean existe(int id) {
        return usuariosDAO.existe(id);
    }
}
