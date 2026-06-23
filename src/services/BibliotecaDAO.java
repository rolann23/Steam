package services;

import model.BibliotecaModel;

import java.util.List;

public interface BibliotecaDAO {
    boolean insertar(BibliotecaModel b);

    List<BibliotecaModel> listarPorUsuario(int id_usuario);

    List<BibliotecaModel> buscarPorTitulo(int id_usuario, String titulo);

    boolean existe(int id_usuario, int id_juego);
}
