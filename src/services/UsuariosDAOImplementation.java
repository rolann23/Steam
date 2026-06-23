package services;

import model.UsuariosModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOImplementation implements UsuariosDAO {
    private DatabaseConnector databaseConnector;

    public UsuariosDAOImplementation(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public boolean insertar(UsuariosModel usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, password) VALUES (?, ?, ?)";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar usuario", e);
        }
    }

    @Override
    public boolean actualizar(UsuariosModel usuario) {
        String sql = "UPDATE usuarios SET nombre=?, correo=?, password=? WHERE id_usuario=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getId_usuario());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar usuario", e);
        }
    }

    @Override
    public boolean eliminar(int id_usuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, id_usuario);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar usuario", e);
        }
    }

    @Override
    public UsuariosModel buscarPorId(int id_usuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, id_usuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al buscar usuario", e);
        }

        return null;
    }

    @Override
    public List<UsuariosModel> listarTodos() {
        String sql = "SELECT * FROM usuarios";
        List<UsuariosModel> lista = new ArrayList<>();

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al listar usuarios", e);
        }

        return lista;
    }

    @Override
    public UsuariosModel login(String correo, String password) {
        String sql = "SELECT * FROM usuarios WHERE correo=? AND password=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error en login", e);
        }

        return null;
    }

    @Override
    public boolean existe(int id_usuario) {
        String sql = "SELECT 1 FROM usuarios WHERE id_usuario=?";

        try (PreparedStatement ps = databaseConnector.GetConnection().prepareStatement(sql)) {

            ps.setInt(1, id_usuario);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al verificar usuario", e);
        }
    }

    private UsuariosModel mapear(ResultSet rs) throws Exception {

        return new UsuariosModel(
                rs.getInt("id_usuario"),
                rs.getInt("id_pais"),
                rs.getString("nombre_usuario"),
                rs.getString("correo"),
                rs.getString("contrasena"),
                rs.getString("avatar_url"),
                rs.getFloat("saldo_billetera"),
                rs.getDate("fecha_registro")
        );
    }
}
