import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";
    static final String DATABASE_NAME = "invoice_management";

    // SQL scripts for creating the database and tables
    static final String[] SQL_SCRIPTS = {
        "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME + ";",
        "USE " + DATABASE_NAME + ";",
        // SQL scripts for creating tables...
        // (Place the SQL scripts for creating tables here)
    };

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Establish database connection
            connection = getConnection();

            // Create database and tables
            statement = connection.createStatement();
            createDatabaseAndTables(statement);

            System.out.println("Database setup completed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Establishes database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // Creates database and tables
    private static void createDatabaseAndTables(Statement statement) throws SQLException {
        for (String sql : SQL_SCRIPTS) {
            statement.execute(sql);
        }
    }
}
