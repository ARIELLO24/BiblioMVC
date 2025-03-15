package biblioMVC.model;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTable {
    public static boolean createTableBook(Connection connection)
    {
        final var sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT NOT NULL,"
                + "author TEXT NOT NULL,"
                + "year TEXT NOT NULL )";
        
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Created or existing user table.");
            System.out.flush();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to create user table: " + e.getMessage());
            System.err.flush();
            
            return false;
        }
    }    
}
