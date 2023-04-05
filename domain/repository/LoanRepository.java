package domain.repository;

import domain.model.Loan;

public interface LoanRepository {
    // 대출 이력 조회 메소드
    void searchLoan(String title);
    // 도서 대출 메소드 writeCSV
    void loanBook(Loan loan);
    // 도서 연장 메소드
    void loanExtention(Loan loan);
    // 도서 반납 메소드
    void returBook(Loan loan);
}
