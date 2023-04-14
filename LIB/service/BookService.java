package service;

import java.util.Collections;

import entity.Book;

public class BookService extends Service<Book> {

    public BookService() {
        // BookManager 클래스의 booklist 메서드를 호출하여 반환된 리스트를 list 필드에 할당합니다.
        list = ml.booklist();
    }

    // 최근 출간순으로 조회
    @Override
    public void printAllList() {
        Collections.sort(list); // 출간일 기준으로 정렬
        for (Book b : list) {
            System.out.println(b);
        }
    }

    // searchBookByAvailable(): 대출 가능한 책을 조회합니다.
    public void searchBookByAvailable() {
        for (Book b : list) {
            if (b.isReturnStatus()) {
                System.out.println(b);
            }
        }
    }

    // loanBook() : 반납 여부를 false로 바꿉니다.
    public void loanBook(String name) {
        for (Book b : list) {
            if (b.getTitle().equals(name)) {
                b.setReturnStatus(false);
            }
        }
    }

}