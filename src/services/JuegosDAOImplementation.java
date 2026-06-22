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
    private Scanner scanner;

    public JuegosDAOImplementation(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void listarJuegos() {
        try {
            System.out.println("\n=== LISTADO DE JUEGOS ===");
            String query = "SELECT j.id_juego, j.titulo, j.desarrollador, j.precio_base, " +
                    "c.nombre as categoria, j.fecha_lanzamiento " +
                    "FROM juegos j " +
                    "INNER JOIN categorias c ON j.id_categoria = c.id_categoria";

            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                System.out.println("ID: " + rs.getInt("id_juego") +
                        " | Titulo: " + rs.getString("titulo") +
                        " | Desarrollador: " + rs.getString("desarrollador") +
                        " | Precio: S/ " + rs.getDouble("precio_base") +
                        " | Categoria: " + rs.getString("categoria") +
                        " | Fecha: " + rs.getDate("fecha_lanzamiento"));
            }
            if (!hayDatos) {
                System.out.println("No hay juegos registrados.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void registrarJuego() {
        try {
            System.out.println("\n=== REGISTRAR NUEVO JUEGO ===");

            // Mostrar categorías disponibles
            mostrarCategorias();

            System.out.print("ID de categoria: ");
            int idCategoria = Integer.parseInt(scanner.nextLine());

            System.out.print("Titulo del juego: ");
            String titulo = scanner.nextLine();

            System.out.print("Descripcion: ");
            String descripcion = scanner.nextLine();

            System.out.print("Precio base (S/): ");
            double precioBase = Double.parseDouble(scanner.nextLine());

            System.out.print("Desarrollador: ");
            String desarrollador = scanner.nextLine();

            System.out.print("URL de portada (opcional): ");
            String portadaUrl = scanner.nextLine();

            System.out.print("Fecha de lanzamiento (YYYY-MM-DD): ");
            String fechaLanzamiento = scanner.nextLine();

            String query = "INSERT INTO juegos (id_categoria, titulo, descripcion, precio_base, " +
                    "desarrollador, portada_url, fecha_lanzamiento) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setInt(1, idCategoria);
            pst.setString(2, titulo);
            pst.setString(3, descripcion);
            pst.setDouble(4, precioBase);
            pst.setString(5, desarrollador);
            pst.setString(6, portadaUrl.isEmpty() ? null : portadaUrl);
            pst.setDate(7, Date.valueOf(fechaLanzamiento));

            int filas = pst.executeUpdate();
            if (filas > 0) {
                System.out.println("Juego registrado correctamente.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizarJuego() {
        try {
            System.out.println("\n=== ACTUALIZAR JUEGO ===");
            System.out.print("ID del juego a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (!juegoExiste(id)) return;

            System.out.print("Nuevo titulo: ");
            String titulo = scanner.nextLine();

            System.out.print("Nuevo precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Nuevo desarrollador: ");
            String desarrollador = scanner.nextLine();

            String query = "UPDATE juegos SET titulo = ?, precio_base = ?, desarrollador = ? WHERE id_juego = ?";
            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setString(1, titulo);
            pst.setDouble(2, precio);
            pst.setString(3, desarrollador);
            pst.setInt(4, id);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                System.out.println("Juego actualizado correctamente.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarJuego() {
        try {
            System.out.println("\n=== ELIMINAR JUEGO ===");
            System.out.print("ID del juego a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (!juegoExiste(id)) return;

            System.out.print("Esta seguro? (S/N): ");
            String confirmacion = scanner.nextLine();

            if (!confirmacion.equalsIgnoreCase("S")) {
                System.out.println("Operacion cancelada.");
                return;
            }

            String query = "DELETE FROM juegos WHERE id_juego = ?";
            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setInt(1, id);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                System.out.println("Juego eliminado correctamente.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buscarJuegosPorTitulo() {
        try {
            System.out.println("\n=== BUSCAR JUEGOS POR TITULO ===");
            System.out.print("Ingrese parte del titulo: ");
            String busqueda = scanner.nextLine();

            String query = "SELECT j.*, c.nombre as categoria FROM juegos j " +
                    "INNER JOIN categorias c ON j.id_categoria = c.id_categoria " +
                    "WHERE j.titulo LIKE ?";

            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setString(1, "%" + busqueda + "%");
            ResultSet rs = pst.executeQuery();

            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                System.out.println(rs.getString("titulo") +
                        " | Precio: S/ " + rs.getDouble("precio_base") +
                        " | Desarrollador: " + rs.getString("desarrollador") +
                        " | Categoria: " + rs.getString("categoria"));
            }
            if (!hayDatos) {
                System.out.println("No se encontraron juegos con ese titulo.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buscarJuegosPorCategoria() {
        try {
            System.out.println("\n=== BUSCAR JUEGOS POR CATEGORIA ===");
            mostrarCategorias();
            System.out.print("Nombre de la categoria: ");
            String categoria = scanner.nextLine();

            String query = "SELECT j.*, c.nombre as categoria FROM juegos j " +
                    "INNER JOIN categorias c ON j.id_categoria = c.id_categoria " +
                    "WHERE c.nombre LIKE ?";

            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setString(1, "%" + categoria + "%");
            ResultSet rs = pst.executeQuery();

            boolean hayDatos = false;
            System.out.println("\nCATEGORIA: " + categoria.toUpperCase());
            while (rs.next()) {
                hayDatos = true;
                System.out.println("   " + rs.getString("titulo") +
                        " | Precio: S/ " + rs.getDouble("precio_base"));
            }
            if (!hayDatos) {
                System.out.println("No hay juegos en esa categoria.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buscarJuegosPorRangoPrecio() {
        try {
            System.out.println("\n=== BUSCAR JUEGOS POR RANGO DE PRECIO ===");
            System.out.print("Precio minimo: ");
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("Precio maximo: ");
            double max = Double.parseDouble(scanner.nextLine());

            String query = "SELECT j.*, c.nombre as categoria FROM juegos j " +
                    "INNER JOIN categorias c ON j.id_categoria = c.id_categoria " +
                    "WHERE j.precio_base BETWEEN ? AND ? ORDER BY j.precio_base";

            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setDouble(1, min);
            pst.setDouble(2, max);
            ResultSet rs = pst.executeQuery();

            boolean hayDatos = false;
            System.out.println("\nJUEGOS ENTRE S/ " + min + " Y S/ " + max);
            while (rs.next()) {
                hayDatos = true;
                System.out.println("   " + rs.getString("titulo") +
                        " | Precio: S/ " + rs.getDouble("precio_base") +
                        " | Categoria: " + rs.getString("categoria"));
            }
            if (!hayDatos) {
                System.out.println("No hay juegos en ese rango de precio.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void comprarJuego() {
        try {
            System.out.println("\n=== COMPRAR JUEGO ===");

            System.out.print("ID del usuario: ");
            int idUsuario = Integer.parseInt(scanner.nextLine());

            System.out.print("ID del juego: ");
            int idJuego = Integer.parseInt(scanner.nextLine());

            System.out.print("Metodo de pago (tarjeta/wallet/paypal): ");
            String metodoPago = scanner.nextLine();

            String call = "{call ComprarJuego(?, ?, ?)}";
            CallableStatement cst = databaseConnector.GetConnection().prepareCall(call);
            cst.setInt(1, idUsuario);
            cst.setInt(2, idJuego);
            cst.setString(3, metodoPago);
            cst.execute();
            System.out.println("Compra realizada con exito!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void listarJuegosConDescuento() {
        try {
            System.out.println("\n=== JUEGOS EN OFERTA ===");
            String query = "SELECT j.titulo, j.precio_base, d.porcentaje, " +
                    "j.precio_base - (j.precio_base * d.porcentaje / 100) as precio_final " +
                    "FROM juegos j " +
                    "INNER JOIN descuentos d ON j.id_juego = d.id_juego " +
                    "WHERE CURDATE() BETWEEN d.fecha_inicio AND d.fecha_fin";

            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                System.out.println(rs.getString("titulo") +
                        " | Precio original: S/ " + rs.getDouble("precio_base") +
                        " | " + rs.getDouble("porcentaje") + "% OFF" +
                        " | Oferta: S/ " + String.format("%.2f", rs.getDouble("precio_final")));
            }
            if (!hayDatos) {
                System.out.println("No hay juegos en oferta actualmente.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<JuegosModel> getJuegos() {
        List<JuegosModel> listaJuegos = new ArrayList<>();
        try {
            String query = "SELECT j.*, c.nombre as categoria FROM juegos j " +
                    "INNER JOIN categorias c ON j.id_categoria = c.id_categoria";
            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                JuegosModel juego = new JuegosModel(
                        rs.getInt("id_juego"),
                        rs.getInt("id_editor"),
                        rs.getInt("id_desarrollador"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("portada_url"),
                        rs.getDate("fecha_lanzamiento")
                );
                listaJuegos.add(juego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaJuegos;
    }

    // Metodos auxiliares
    private void mostrarCategorias() {
        try {
            String query = "SELECT * FROM categorias";
            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            System.out.println("\nCATEGORIAS DISPONIBLES:");
            while (rs.next()) {
                System.out.println("ID " + rs.getInt("id_categoria") + " -> " + rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean juegoExiste(int id) {
        try {
            String query = "SELECT id_juego FROM juegos WHERE id_juego = ?";
            PreparedStatement pst = databaseConnector.GetConnection().prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println("El juego con ID " + id + " NO existe.");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
