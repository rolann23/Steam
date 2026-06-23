package services;

import model.ComprasModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComprasDAOImplementation implements ComprasDAO {
    private DatabaseConnector databaseConnector;

    public ComprasDAOImplementation(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public boolean insertar(ComprasModel compra) {

        String sql = "INSERT INTO compras (id_usuario, id_metodo, total, fecha_compra) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, compra.getId_usuario());
            ps.setInt(2, compra.getId_metodo());
            ps.setFloat(3, compra.getTotal());
            ps.setDate(4, compra.getFecha_compra());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean actualizar(ComprasModel compra) {

        String sql = "UPDATE compras SET id_usuario=?, id_metodo=?, total=?, fecha_compra=? WHERE id_compra=?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, compra.getId_usuario());
            ps.setInt(2, compra.getId_metodo());
            ps.setFloat(3, compra.getTotal());
            ps.setDate(4, compra.getFecha_compra());
            ps.setInt(5, compra.getId_compra());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminar(int id_compra) {

        String sql = "DELETE FROM compras WHERE id_compra=?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, id_compra);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ComprasModel buscarPorId(int id_compra) {

        String sql = "SELECT * FROM compras WHERE id_compra=?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, id_compra);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<ComprasModel> listarTodos() {

        List<ComprasModel> lista = new ArrayList<>();

        String sql = "SELECT * FROM compras";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public boolean existe(int id_compra) {

        String sql = "SELECT * FROM compras WHERE id_compra=?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, id_compra);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ComprasModel mapear(ResultSet rs) throws Exception {

        return new ComprasModel(
                rs.getInt("id_compra"),
                rs.getInt("id_usuario"),
                rs.getInt("id_metodo"),
                rs.getFloat("total"),
                rs.getDate("fecha_compra")
        );
    }
}
