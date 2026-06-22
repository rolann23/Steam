package services;

import model.JuegosModel;

import java.util.List;

public interface JuegosDAO {
    // CRUD básico
    public void listarJuegos();
    public List<JuegosModel> getJuegos();
    public void registrarJuego();
    public void actualizarJuego();
    public void eliminarJuego();

    // Operaciones avanzadas
    public void buscarJuegosPorTitulo();
    public void buscarJuegosPorCategoria();
    public void buscarJuegosPorRangoPrecio();
    public void comprarJuego();  // Usando CallableStatement
    public void listarJuegosConDescuento();  // JOIN con descuentos
}
