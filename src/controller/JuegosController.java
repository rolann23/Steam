package controller;

import model.JuegosModel;
import services.DatabaseConnector;
import services.JuegosDAO;
import services.JuegosDAOImplementation;

import java.util.List;

public class JuegosController {
    private JuegosDAO juegosDAO;

    public JuegosController(DatabaseConnector databaseConnector) {
        juegosDAO = new JuegosDAOImplementation(databaseConnector);
    }

    public boolean guardarJuego(JuegosModel juego) {
        return juegosDAO.insertar(juego);
    }

    public boolean actualizarJuego(JuegosModel juego) {
        return juegosDAO.actualizar(juego);
    }

    public boolean eliminarJuego(int idJuego) {
        return juegosDAO.eliminar(idJuego);
    }

    public JuegosModel buscarPorId(int idJuego) {
        return juegosDAO.buscarPorId(idJuego);
    }

    public List<JuegosModel> listarJuegos() {
        return juegosDAO.listarTodos();
    }

    public List<JuegosModel> buscarPorTitulo(String titulo) {
        return juegosDAO.buscarPorTitulo(titulo);
    }

    public boolean existe(int idJuego) {
        return juegosDAO.existe(idJuego);
    }
}
