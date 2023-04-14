package domain.repository;

import java.util.List;
import domain.model.Book;
import domain.model.User;

public interface BookRepository {

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);

    List<Book> findAll();

    Book findByIsbn(int isbn);

    Book findByTitle(String title);
}
