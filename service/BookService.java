package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import data.Data;
import domain.model.Book;
import domain.repository.BookRepository;


public class BookService implements BookRepository {
    private Data<Book> data;
    
    private List<Book> books = new ArrayList<>();
    
    public BookService() {
    }
    public BookService(Data<Book> data) {
        this.data = data;
    }

    @Override
    public void addBook(Book book) {
        Optional<Book> findBook = books.stream().filter(e -> e.getId() == book.getId()).findFirst();

        if (!findBook.isEmpty()) {
            throw new IllegalArgumentException("동일한 ID가 존재합니다");
        }
        books.add(book);
        
        // File, Cloud, Db
        if (data != null) {
            data.save(books);
        }
    }

    @Override
    public void updateBook(Book book) {
        // 인수로 받은 Book 객체의 id 값과 일치하는 Book 객체의 인덱스를 찾는다.
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            Book e = books.get(i);
            if (e.getId() == book.getId()) {
                index = i;
                break;
            }
        }

        // 찾은 인덱스가 유효하다면 해당 인덱스에 위치한 Book 객체를 인수로 받은 Book 객체로 교체한다.
        if (index != -1) {
            books.set(index, book);
            
            // 외부 데이터 저장소 (data)에 변경된 Book 리스트를 저장한다.
            if (data != null) {
                data.save(books);
            }
        }
    }

    @Override
    public void deleteBook(Book book) {
        books.remove(book);
        if (data != null) {
            data.save(books);
        }
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findByIsbn(int isbn) {
//        Optional<User> user = users.stream().filter(e -> e.getId() == id).findFirst();
//        if (!user.isEmpty()) {
//            return user.get();
//        } 
//        return null;
        Book book = null;
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i); 
            if (book.getId() == isbn) {
                break;
            }
        }
        return book;
    }

    @Override
    public Book findByTitle(String title) {
        Book book = null;
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i); 
            if (book.getTitle().equals(title)) {
                break;
            }
        }
        return book;
    }

}