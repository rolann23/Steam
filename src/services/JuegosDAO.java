package services;

import model.JuegosModel;

import java.util.List;

public interface JuegosDAO {
    public void ListJuegos();
    public List<JuegosModel> GetJuegos();
    public void RegisterJuegos();
    public void DeleteJuegos();
    public void UpdateJuegos();

    public void buscarJuegosPorTitulo();
    public void buscarJuegosPorCategoria();
    public void buscarJuegosPorRangoPrecio();
    public void comprarJuego();  // Usando CallableStatement
    public void listarJuegosConDescuento();
}
