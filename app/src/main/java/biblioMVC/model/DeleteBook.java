/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.model;
/**
 *
 * @author ARIELLORENZ
 */
// Importação das classes necessárias para conexão e execução de comandos SQL
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBook {
    
    // Método para deletar um usuário do banco de dados com base no ID fornecido
    public static void deleteBook(Connection conexao, int id) {
        
        // Comando SQL para deletar um usuário da tabela 'usuarios' com base no ID
        String sql = "DELETE FROM usuarios WHERE id = ?";
        
        // Bloco try-with-resources para garantir que o PreparedStatement seja fechado automaticamente
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            
            // Define o valor do parâmetro '?' no SQL como o ID do usuário passado no método
            pstmt.setInt(1, id);
            
            // Executa a atualização (DELETE) no banco de dados e armazena o número de linhas afetadas
            int rowsDeleted = pstmt.executeUpdate();
            
            // Verifica se alguma linha foi deletada
            if (rowsDeleted > 0) { 
                // Se pelo menos um usuário foi deletado, exibe uma mensagem de sucesso
                System.out.println("Deleted book with succession!");
            } else {
                // Caso contrário, informa que nenhum usuário foi encontrado com o ID fornecido
                System.out.println("No Books found with the provided ID");
            }
        } catch (Exception e) {
            // Captura qualquer exceção que ocorra durante a execução do código e exibe a mensagem de erro
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }
}
