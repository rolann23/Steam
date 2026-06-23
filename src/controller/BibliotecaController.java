package controller;

import model.BibliotecaModel;
import services.BibliotecaDAO;
import services.BibliotecaDAOImplementation;
import services.DatabaseConnector;

import java.util.List;

public class BibliotecaController {
    private BibliotecaDAO bibliotecaDAO;
    public BibliotecaController(DatabaseConnector db) {
        this.bibliotecaDAO = new BibliotecaDAOImplementation(db);
    }

    public List<BibliotecaModel> listarPorUsuario(int idUsuario) {
        return bibliotecaDAO.listarPorUsuario(idUsuario);
    }

    public List<BibliotecaModel> buscarPorTitulo(int idUsuario, String titulo) {
        return bibliotecaDAO.buscarPorTitulo(idUsuario, titulo);
    }
}
