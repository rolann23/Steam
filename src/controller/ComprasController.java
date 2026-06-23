package controller;

import model.ComprasModel;
import services.ComprasDAO;
import services.ComprasDAOImplementation;
import services.DatabaseConnector;

import java.util.List;

public class ComprasController {
    private ComprasDAO comprasDAO;

    public ComprasController(DatabaseConnector databaseConnector) {
        this.comprasDAO = new ComprasDAOImplementation(databaseConnector);
    }

    public boolean registrar(ComprasModel compra) {
        return comprasDAO.insertar(compra);
    }

    public boolean actualizar(ComprasModel compra) {
        return comprasDAO.actualizar(compra);
    }

    public boolean eliminar(int idCompra) {
        return comprasDAO.eliminar(idCompra);
    }

    public ComprasModel buscar(int idCompra) {
        return comprasDAO.buscarPorId(idCompra);
    }

    public List<ComprasModel> listar() {
        return comprasDAO.listarTodos();
    }

    public boolean existe(int idCompra) {
        return comprasDAO.existe(idCompra);
    }
}
