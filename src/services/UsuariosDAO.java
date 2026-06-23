package services;

import model.UsuariosModel;

import java.util.List;

public interface UsuariosDAO {
    boolean insertar(UsuariosModel usuario);

    boolean actualizar(UsuariosModel usuario);

    boolean eliminar(int id_usuario);

    UsuariosModel buscarPorId(int id_usuario);

    List<UsuariosModel> listarTodos();

    UsuariosModel login(String correo, String password);

    boolean existe(int id_usuario);
}
