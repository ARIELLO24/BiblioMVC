package biblioMVC.model;

import java.sql.Connection;
import java.sql.SQLException;

public class CriarTabela {
    public static boolean criarTabelaUsuarios(Connection connection)
    {
        final var sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT NOT NULL,"
                + "email TEXT NOT NULL UNIQUE,"
                + "senha TEXT NOT NULL )";
        
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabela de usuários criada ou já existente.");
            System.out.flush();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Falha ao criar a tabela de usuários: " + e.getMessage());
            System.err.flush();
            
            return false;
        }
    }    
}
