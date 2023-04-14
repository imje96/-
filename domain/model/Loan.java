package domain.model;

public class Loan {
    private String borrowBook; // 도서대출 
    private String dueDateExtend; // 대출연장



    public String getBorrowBook() {
        return borrowBook;
    }

    public void setBorrowBook(String borrowBook) {
        this.borrowBook = borrowBook;
    }

    public String getDueDateExtend() {
        return dueDateExtend;
    }

    public void setDueDateExtend(String dueDateExtend) {
        this.dueDateExtend = dueDateExtend;
    }


}
