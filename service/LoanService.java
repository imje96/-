package service;

import java.util.ArrayList;
import java.util.List;
import data.Data;
import domain.model.Book;
import domain.model.Loan;
import domain.model.User;
import domain.repository.LoanRepository;
import domain.repository.UserRepository;



public class LoanService implements LoanRepository {
    private Data<Loan> data;
    
    private List<Loan> loans = new ArrayList<>();
    
    public LoanService() {
    }
    
    public LoanService(Data<Loan> data) {
        this.data = data;
    }

    @Override
    public void searchLoan(String title) {
        Loan loan = null;
        for (int i = 0; i < loans.size(); i++) {
            loan = loans.get(i);
            if (loan.getBookTitle().equals(title)) {
                break;
            }
        }
        
    }
//    @Override
//    public void updateBook(Book book) {
//        int index = -1;
//        for (int i = 0; i < books.size(); i++) {
//            Book e = books.get(i);
//            if (e.getId() == book.getId()) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            books.set(index, book);
//            if (data != null) {
//                data.save(books);
//            }
//        }
//    }

    @Override
    public void loanBook(Loan loan) {
        int id = 0;
        for (int i = 0; i < loans.size(); i++) {
            id = Math.max(id, data.getId() + 1);
        }
        loan.setId(id);
        data.save(loan);
          
        }
    

    @Override
    public void loanExtention(Loan loan) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void returBook(Loan loan) {
        // TODO Auto-generated method stub
        
    }
}