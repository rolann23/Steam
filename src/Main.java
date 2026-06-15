import services.DatabaseConnector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector(
                "jdbc:mysql://localhost:3306/","steam_db",
                "root",""
        );
        databaseConnector.ConnectDatabase();
    }
}