/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.model;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ARIELLORENZ
 */
public class BookDAO {
        
    // Atributo para armazenar a conexão com o banco de dados
    private Connection conexao;

    // Construtor da classe, responsável por estabelecer a conexão com o banco de dados
    public BookDAO() {
        conectar();
    }

    // Método privado para estabelecer a conexão com o banco de dados
    private void conectar() {
        try {
            // Estabelece a conexão com o banco de dados SQLite
            conexao = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");
        } catch (SQLException e) {
            // Se ocorrer um erro na conexão, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    // Método público para adicionar um novo livro ao banco de dados
    public void adicionarLivro(Book book) {
        // Comando SQL para inserir um novo livro na tabela 'livros'
        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Definindo os parâmetros do comando SQL com os dados do livro
            stmt.setString(1, book.getTitulo());
            stmt.setString(2, book.getAutor());
            stmt.setInt(3, book.getAno());
            
            // Executa a atualização no banco de dados
            stmt.executeUpdate();
            
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
        } catch (SQLException e) {
            // Se ocorrer um erro durante a inserção, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao adicionar livro: " + e.getMessage());
        }
    }


    
}

/*
A classe LivroDAO é uma implementação da camada de Data Access Object (DAO), 
que gerencia a interação entre a aplicação e o banco de dados, nesse caso, 
para a manipulação de dados relacionados a livros.

*/