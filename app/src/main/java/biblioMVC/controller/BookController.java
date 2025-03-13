package biblioMVC.controller;


import biblioMVC.model.BookDAO;

public class BookController {

    private BookDAO bookDAO;

    public BookController() {

        this.bookDAO = new BookDAO();

    }

    public String adicionarLivros(String titulo, String autor, String anoTexto, int id)  {

        try {

            int ano = Integer.parseInt(anoTexto);

            Livro livro = new Livro (id, titulo, autor, ano);

            livroDAO.adicionarLivro(livro);

            return "Livro adicionado com sucesso!.";

        } catch (NumberFormatException e) {

            return "Erro: " + e.getMessage();

        }

    }



}
