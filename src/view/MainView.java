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

    }
}
