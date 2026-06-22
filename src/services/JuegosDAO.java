package services;

import model.JuegosModel;

import java.util.List;

public interface JuegosDAO {

    boolean insertar(JuegosModel juego);

    boolean actualizar(JuegosModel juego);

    boolean eliminar(int id_juego);

    JuegosModel buscarPorId(int id_juego);

    List<JuegosModel> listarTodos();

    List<JuegosModel> buscarPorTitulo(String titulo);

    boolean existe(int id_juego);
}
