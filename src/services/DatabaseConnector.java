package services;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    private Connection connection;
    private String url;
    private String databaseName;
    private String userName;
    private String password;

    public DatabaseConnector(String url, String databaseName,
                             String userName, String password) {
        this.url = url;
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }

    public void ConnectDatabase() {
        try {
            connection = DriverManager.getConnection(url + databaseName,
                    userName, password);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection GetConnection() {
        return connection;
    }
}
