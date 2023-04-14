package service;

import java.util.Collections;

import entity.Loan;

public class LoanService extends Service<Loan> {

    public LoanService() {
        // BookService 클래스의 booklist 메서드를 호출하여 list 필드에 할당
        list = ml.loanlist();
    }
    
    // searchLoanByName() : 대출이력조회
    public void searchLoanByName(String name) {
        Collections.sort(list);
        for (Loan l : list) {
            if(l.getMemberName().equals(name)) {
                System.out.println(l);              
            }
        }
    }
    
    // 책 대여하기
    public void loanBook(Loan loan) {
        int id = 0;
        for (Loan l : list) {
            id = Math.max(id, l.getId() + 1);
        }
        loan.setId(id);
        list.add(loan);
    }
    
    // 연장 가능한 책을 조회
    public boolean searchAvaliableRenew(String name) {
        boolean result = false;
        for (Loan l : list) {
            //연장을 하지 않은 경우 & 받은 이름이 회원과 동일한 경우 & 반납을 하지 않은 경우 
            if (!l.isExtension() && l.getMemberName().equals(name) && !l.isRenewStatus()) {
                result = true;
                System.out.println(l);
            }
        }
        return result;
    }
    
    // 대출 연장하기 
    public boolean extendLoan(String memberName, String bookName) {
        boolean result = false;
        for (Loan l : list) {
            //받은 이름이 회원과 동일한 경우 & 받은 책 이름이 등록된 책 이름과 동일한 경우  
            if (l.getMemberName().equals(memberName) && l.getBookTitle().equals(bookName)) {
                result = true;
                l.setExtension(true);
                // 일주일 연장하기 
                l.setDeadline(l.getDeadline() + 7);
                break;
            }
        }
        return result;
    }

}