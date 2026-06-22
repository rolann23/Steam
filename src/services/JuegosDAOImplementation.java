package services;

import model.JuegosModel;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JuegosDAOImplementation implements JuegosDAO {
    private DatabaseConnector databaseConnector;


    public JuegosDAOImplementation(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public boolean insertar(JuegosModel juego) {
        String sql = "INSERT INTO juegos (id_editor, id_desarrollador, titulo, descripcion, portada_url, fecha_lanzamiento) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, juego.getId_editor());
            ps.setInt(2, juego.getId_desarrollador());
            ps.setString(3, juego.getTitulo());
            ps.setString(4, juego.getDescripcion());
            ps.setString(5, juego.getPortada_url());
            ps.setDate(6, juego.getFecha_lanzamiento());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar juego", e);
        }
    }

    @Override
    public boolean actualizar(JuegosModel juego) {
        String sql = "UPDATE juegos SET id_editor=?, id_desarrollador=?, titulo=?, descripcion=?, portada_url=?, fecha_lanzamiento=? " +
                "WHERE id_juego=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, juego.getId_editor());
            ps.setInt(2, juego.getId_desarrollador());
            ps.setString(3, juego.getTitulo());
            ps.setString(4, juego.getDescripcion());
            ps.setString(5, juego.getPortada_url());
            ps.setDate(6, juego.getFecha_lanzamiento());
            ps.setInt(7, juego.getId_juego());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar juego", e);
        }
    }

    @Override
    public boolean eliminar(int id_juego) {
        String sql = "DELETE FROM juegos WHERE id_juego=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, id_juego);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar juego", e);
        }
    }

    @Override
    public JuegosModel buscarPorId(int id_juego) {
        String sql = "SELECT * FROM juegos WHERE id_juego=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, id_juego);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al buscar juego", e);
        }

        return null;
    }

    @Override
    public List<JuegosModel> listarTodos() {
        String sql = "SELECT * FROM juegos";
        List<JuegosModel> lista = new ArrayList<>();

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al listar juegos", e);
        }

        return lista;
    }

    @Override
    public List<JuegosModel> buscarPorTitulo(String titulo) {
        String sql = "SELECT * FROM juegos WHERE titulo LIKE ?";
        List<JuegosModel> lista = new ArrayList<>();

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setString(1, "%" + titulo + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al buscar por título", e);
        }

        return lista;
    }

    @Override
    public boolean existe(int id_juego) {
        String sql = "SELECT 1 FROM juegos WHERE id_juego=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, id_juego);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al verificar juego", e);
        }
    }

    private JuegosModel mapear(ResultSet rs) throws Exception {
        return new JuegosModel(
                rs.getInt("id_juego"),
                rs.getInt("id_editor"),
                rs.getInt("id_desarrollador"),
                rs.getString("titulo"),
                rs.getString("descripcion"),
                rs.getString("portada_url"),
                rs.getDate("fecha_lanzamiento")
        );
    }

}
