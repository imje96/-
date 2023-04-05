package save;

import java.util.ArrayList;
import java.util.List;

import Book.Book;
import Loan.Loan;
import Member.Member;

public class ListMaker {

    CSVReader cr = new CSVReader();
    
    public List<Member> memberlist() {
        List<List<String>> list = cr.readCSV("member.csv");
        List<Member> memberlist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            Member mem = new Member();
            mem.setId(l.get(0));
            mem.setName(l.get(1));
            mem.setAddress(l.get(2));
            mem.setPhoneNumber(l.get(3));
            mem.setBirthday(l.get(4));
            memberlist.add(mem);
        }
        return memberlist;
    }

    public List<Book> booklist() {
        List<List<String>> list = cr.readCSV("book.csv");
        List<Book> booklist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            Book b = new Book();
            b.setIsbn(l.get(0));
            b.setTitle(l.get(1));
            b.setAuthor(l.get(2));
            b.setPublisherDate(l.get(3));
            b.setIsAvailable(Boolean.valueOf(l.get(4)));
            booklist.add(b);
        }
        return booklist;
    }

    
    public List<Loan> loanlist() {
        List<List<String>> list = cr.readCSV("loan.csv");
        List<Loan> loanlist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            Loan loan = new Loan();
            loan.setBookTitle(l.get(0));
            loan.setMemberName(l.get(1));
            loan.setLoanDate(l.get(2));
            loan.setDueDate(l.get(3));
            loan.setIsRenewable(Boolean.valueOf(l.get(4)));
            loanlist.add(loan);
        }
        return loanlist;
    }

}
