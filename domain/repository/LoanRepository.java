package domain.repository;

import domain.model.Loan;

public interface LoanRepository {
    // 대출한 회원
    void id(int id);
    // 도서 대출 메소드
    void borrowLoan(String title);
    // 대출 연장 메소드 writeCSV
    void dueDateExtend(Loan loan);
    // 반납 기한 조회 메소드
    void dueDate(Loan loan);
    // 도서 연장 상태 메소드
    void isRenewStatus(Loan loan);
}
