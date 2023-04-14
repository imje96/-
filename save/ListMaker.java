package save;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import domain.model.*;

public class ListMaker {
    private CSVReader cr = new CSVReader();

    public List<User> userlist() {
        List<List<String>> list = cr.readCSV("member.csv");
        List<User> userlist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            User user = new User();
            user.setId(Integer.parseInt(l.get(0)));
            user.setName(l.get(1));
            user.setAddress(l.get(2));
            user.setNumber(l.get(3));
            user.setBirthDate(LocalDate.parse(l.get(4), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            user.setJoinDate(LocalDate.parse(l.get(5), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            userlist.add(user);
        }
        return userlist;
    }

    public List<Book> booklist() {
        List<List<String>> list = cr.readCSV("book.csv");
        List<Book> booklist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            Book book = new Book();
            book.setIsbn(l.get(0));
            book.setTitle(l.get(1));
            book.setAuthor(l.get(2));
            book.setPublishDate(LocalDate.parse(l.get(3), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            book.setIsAvailable(Boolean.valueOf(l.get(4)));
            booklist.add(book);
        }
        return booklist;
    }

    public List<Loan> loanlist() {
        List<List<String>> list = cr.readCSV("loan.csv");
        List<Loan> loanlist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            Loan loan = new Loan();
            loan.setId(Integer.parseInt(l.get(0)));
            loan.setBookTitle(l.get(1));
            loan.setLoanDate(LocalDate.parse(l.get(2), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            loan.setDueDate(LocalDate.parse(l.get(3), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            loan.setIsRenewStatus(Boolean.valueOf(l.get(4)));
            loanlist.add(loan);
        }
        return loanlist;
    }
}


//package Library;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import domain.model.*;
//import domain.repository.*;
//import presentation.*;
//import data.*;
//import save.CSVReader;
//
//public class ListMaker {
//
//    CSVReader cr = new CSVReader();
//    
//    public List<User> userlist() {
//        List<List<String>> list = cr.readCSV("member.csv");
//        List<User> userlist = new ArrayList<>();
//        for (int i = 1; i < list.size(); i++) {
//            List<String> l = list.get(i);
//            User user = new User();
//            user.setId(l.get(0));
//            user.setName(l.get(1));
//            user.setAddress(l.get(2));
//            user.setPhoneNumber(l.get(3));
//            user.setBirthday(l.get(4));
//            user.setJoinDate(l.get(5));
//            memberlist.add(user);
//        }
//        return memberlist;
//    }
//
//    public List<Book> booklist() {
//        List<List<String>> list = cr.readCSV("book.csv");
//        List<Book> booklist = new ArrayList<>();
//        for (int i = 1; i < list.size(); i++) {
//            List<String> l = list.get(i);
//            Book b = new Book();
//            b.setIsbn(l.get(0));
//            b.setTitle(l.get(1));
//            b.setAuthor(l.get(2));
//            b.setPublishDate(l.get(3));
//            b.setIsAvailable(Boolean.valueOf(l.get(4)));
//            booklist.add(b);
//        }
//        return booklist;
//    }
//
//    
//    public List<Loan> loanlist() {
//        List<List<String>> list = cr.readCSV("loan.csv");
//        List<Loan> loanlist = new ArrayList<>();
//        for (int i = 1; i < list.size(); i++) {
//            List<String> l = list.get(i);
//            Loan loan = new Loan();
//            loan.setId(l.get(0));
//            loan.setBookTitle(l.get(1));
//            loan.setLoanDate(l.get(2));
//            loan.setDueDate(l.get(3));
//            loan.setIsRenewStatus(Boolean.valueOf(l.get(4)));
//            loanlist.add(loan);
//        }
//        return loanlist;
//    }
//
//}