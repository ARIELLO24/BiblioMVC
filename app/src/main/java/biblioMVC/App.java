/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package biblioMVC;

import biblioMVC.model.ConexaoSQLite;
import biblioMVC.model.CreateTable;

import biblioMVC.view.GrapichalUserInterface;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        // Conectar ao banco de dados SQLite
        Connection conexao = ConexaoSQLite.conectar();

        // Criar a tabela de livros se não existir
        CreateTable.createTableBook(conexao);

       
       
        new GrapichalUserInterface().setVisible(true);
        
    }
}