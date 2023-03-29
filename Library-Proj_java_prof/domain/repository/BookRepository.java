package domain.repository;

import java.util.List;
import domain.model.Book;

public interface BookRepository {

    void addUser(Book book);

    void updateUser(Book book);

    void deleteUser(Book book);

    List<Book> findAll();

    Book findById(int id);

    Book findByName(String name);
}
