package biblioMVC.controller;

import biblioMVC.model.Book;
import biblioMVC.model.BookDAO;

public class BookController {
    private BookDAO bookDAO;
    

    public BookController() {
        this.bookDAO = new BookDAO();
    }

    public String addBook(String titulo, String autor, String anoTexto) {
        try {
            int ano = Integer.parseInt(anoTexto); //parserInt faz parte do Integer
            bookDAO.addBook(new Book( titulo, autor, ano));
            return "Livro adicionado com sucesso";
        } catch (NumberFormatException e) {
            return "Error" + e.getMessage();
        }
    }
}
