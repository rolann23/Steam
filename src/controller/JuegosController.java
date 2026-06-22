package controller;

import model.JuegosModel;
import services.DatabaseConnector;
import services.JuegosDAO;
import services.JuegosDAOImplementation;

import java.util.List;

public class JuegosController {
    private JuegosDAO juegosDAO;

    public JuegosController(DatabaseConnector databaseConnector) {
        this.juegosDAO = new JuegosDAOImplementation(databaseConnector);
    }

    // CRUD básico
    public void listarJuegos() {
        juegosDAO.listarJuegos();
    }
    public void registrarJuego() {
        juegosDAO.registrarJuego();
    }
    public void actualizarJuego() {
        juegosDAO.actualizarJuego();
    }
    public void eliminarJuego() {
        juegosDAO.eliminarJuego();
    }
    // Operaciones avanzadas
    public void buscarPorTitulo() {
        juegosDAO.buscarJuegosPorTitulo();
    }
    public void buscarPorCategoria() {
        juegosDAO.buscarJuegosPorCategoria();
    }
    public void buscarPorRangoPrecio() {
        juegosDAO.buscarJuegosPorRangoPrecio();
    }
    public void comprarJuego() {
        juegosDAO.comprarJuego();
    }
    public void listarOfertas() {
        juegosDAO.listarJuegosConDescuento();
    }
    public List<JuegosModel> getJuegos() {
        return juegosDAO.getJuegos();
    }
}
