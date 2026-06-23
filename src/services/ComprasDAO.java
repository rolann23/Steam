package services;

import model.ComprasModel;

import java.util.List;

public interface ComprasDAO {
    boolean insertar(ComprasModel compra);

    boolean actualizar(ComprasModel compra);

    boolean eliminar(int id_compra);

    ComprasModel buscarPorId(int id_compra);

    List<ComprasModel> listarTodos();

    boolean existe(int id_compra);
}
