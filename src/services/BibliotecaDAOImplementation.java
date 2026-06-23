package services;

import model.BibliotecaModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAOImplementation implements BibliotecaDAO {
    private DatabaseConnector databaseConnector;

    public BibliotecaDAOImplementation(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public boolean insertar(BibliotecaModel b) {

        String sql = "INSERT INTO biblioteca (id_usuario, id_juego, fecha_adquirido, horas_jugadas) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, b.getId_usuario());
            ps.setInt(2, b.getId_juego());
            ps.setDate(3, b.getFecha_adquirido());
            ps.setInt(4, b.getHoras_jugadas());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BibliotecaModel> listarPorUsuario(int id_usuario) {

        List<BibliotecaModel> lista = new ArrayList<>();

        String sql =
                "SELECT b.* " +
                        "FROM biblioteca b " +
                        "WHERE b.id_usuario = ?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, id_usuario);

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
    public List<BibliotecaModel> buscarPorTitulo(int id_usuario, String titulo) {

        List<BibliotecaModel> lista = new ArrayList<>();

        String sql =
                "SELECT b.* " +
                        "FROM biblioteca b " +
                        "INNER JOIN juegos j ON b.id_juego = j.id_juego " +
                        "WHERE b.id_usuario = ? AND j.titulo LIKE ?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, id_usuario);
            ps.setString(2, "%" + titulo + "%");

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
    public boolean existe(int id_usuario, int id_juego) {

        String sql = "SELECT 1 FROM biblioteca WHERE id_usuario=? AND id_juego=?";

        try {
            PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);

            ps.setInt(1, id_usuario);
            ps.setInt(2, id_juego);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BibliotecaModel mapear(ResultSet rs) throws Exception {

        return new BibliotecaModel(
                rs.getInt("id_usuario"),
                rs.getInt("id_juego"),
                rs.getDate("fecha_adquirido"),
                rs.getInt("horas_jugadas")
        );
    }

}
