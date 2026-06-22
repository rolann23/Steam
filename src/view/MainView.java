package view;

import controller.JuegosController;
import services.DatabaseConnector;

import java.util.Scanner;

public class MainView {
    private DatabaseConnector databaseConnector;
    private JuegosController juegosController;

    public MainView() {
        databaseConnector = new DatabaseConnector(
                "jdbc:mysql://localhost:3306/", "steam_db", "root", "");
        databaseConnector.ConnectDatabase();
        juegosController = new JuegosController(databaseConnector);
    }

    public void run() {
        boolean ejecutando = true;
        Scanner scanner = new Scanner(System.in);

        while (ejecutando) {
            System.out.println("\n === GESTIÓN DE VIDEJUEGOS === ");
            System.out.println("1. Listar todos los juegos");
            System.out.println("2. Registrar nuevo juego");
            System.out.println("3. Actualizar juego");
            System.out.println("4. Eliminar juego");
            System.out.println("5. Buscar juegos por título");
            System.out.println("6. Buscar juegos por categoría");
            System.out.println("7. Buscar por rango de precio");
            System.out.println("8. Comprar juego");
            System.out.println("9. Ver juegos en oferta");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    juegosController.listarJuegos();
                    break;
                case 2:
                    juegosController.registrarJuego();
                    break;
                case 3:
                    juegosController.actualizarJuego();
                    break;
                case 4:
                    juegosController.eliminarJuego();
                    break;
                case 5:
                    juegosController.buscarPorTitulo();
                    break;
                case 6:
                    juegosController.buscarPorCategoria();
                    break;
                case 7:
                    juegosController.buscarPorRangoPrecio();
                    break;
                case 8:
                    juegosController.comprarJuego();
                    break;
                case 9:
                    juegosController.listarOfertas();
                    break;
                case 10:
                    System.out.println("\n¡Gracias por usar nuestra plataforma!");
                    System.out.println("Byeee");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
