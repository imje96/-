package presentation;

import java.util.Random;
import java.util.Scanner;
import domain.model.Book;
import domain.repository.BookRepository;

public class BookController {
    private BookRepository bookRepository;
    
    private boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);
    
    private Book recentDeletedBook = null;
    
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void printMenu() {
        while (!isExit) {
            System.out.println("1. 도서등록, 2. 도서목록, 3. 도서수정, 4. 도서삭제, 5. 삭제취소 0. 뒤로");
            int target = scanner.nextInt();
            if (target == 1) {
                addBook();
            } else if (target == 2) {
                printBookList();
            } else if (target == 3) {
                removeBook();
            } else if (target == 5) {
                restoreBook();
            } else if (target == 0) {
                isExit = true;
            }
        }
    }
    
    public void printBookList() {
        System.out.println(bookRepository.findAll());
    }
    
    public void addBook() {
        // 쭉 받고
        String title = String.valueOf(new Random().nextInt(1000));
        bookRepository.addBook(new Book(title));
    }
    
    public void removeBook() {
        System.out.println("몇 번 id 삭제?");
        int target = scanner.nextInt();
        
        recentDeletedBook = bookRepository.findByIsbn(target);
        bookRepository.deleteBook(recentDeletedBook);
        System.out.println(target + " 이 지워졌습니다");
    }
    
    public void updateUser() {
        
    }
    
    public void restoreBook() {
        bookRepository.addBook(recentDeletedBook);
        System.out.println("id : " + recentDeletedBook.getId() + "인 유저가 복구 됐어요");
    }
    
    public void exit() {
        
    }
}
