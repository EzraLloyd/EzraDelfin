import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/invoice_management";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Establishes database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // CRUD operations for clients
    public static void addClient(Client client) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO clients (name, email, phone, address) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getPhone());
            statement.setString(4, client.getAddress());
            statement.executeUpdate();
            System.out.println("Client added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM clients")) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setClientId(resultSet.getInt("client_id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setAddress(resultSet.getString("address"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // Add similar methods for updating and deleting clients

    // CRUD operations for services
    // Add similar methods for adding, updating, deleting, and retrieving services

    // CRUD operations for invoices
    // Add similar methods for adding, updating, deleting, and retrieving invoices

    // Add more methods for analytics, error handling, and other functionalities
}
