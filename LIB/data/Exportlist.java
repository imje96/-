package data;

import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Loan;
import entity.User;

public class Exportlist {
    
    CSVWriter csvwriter = new CSVWriter();

    public void exportUser(List<User> userlist) {
        List<String[]> export = new ArrayList<>();
        String[] index = {"id", "name", "joinDate", "address", "phoneNumber", "birthday", "age"};
        export.add(index);
        for(int i=0; i<userlist.size(); i++) {
            String[] user = new String[7];
            user[0] = String.valueOf(userlist.get(i).getId());
            user[1] = userlist.get(i).getName();
            user[2] = userlist.get(i).getJoinDate();
            user[3] = userlist.get(i).getAddress();
            user[4] = userlist.get(i).getPhoneNumber();
            user[5] = userlist.get(i).getBirthday();
            user[6] = String.valueOf(userlist.get(i).getAge());
            export.add(user);
        }
        csvwriter.writeCSV(export, "member.csv");
    }
    
    public void exportBook(List<Book> booklist) {
        List<String[]> export = new ArrayList<>();
        String[] index = {"id", "title", "issueDate", "returnStatus"};
        export.add(index);
        for(int i=0; i<booklist.size(); i++) {
            String[] book = new String[4];
            book[0] = String.valueOf(booklist.get(i).getId());
            book[1] = booklist.get(i).getTitle();
            book[2] = booklist.get(i).getIssueDate();
            book[3] = String.valueOf(booklist.get(i).isReturnStatus());
            export.add(book);
        }
        csvwriter.writeCSV(export, "book.csv");
    }
    
    public void exportLoan(List<Loan> loanlist) {
        List<String[]> export = new ArrayList<>();
        String[] index = {"id", "memberName", "bookTitle", "renewStatus" , "loanDate", "deadline", "extension"};
        export.add(index);
        for(int i=0; i<loanlist.size(); i++) {
            String[] loan = new String[7];
            loan[0] = String.valueOf(loanlist.get(i).getId());
            loan[1] = loanlist.get(i).getMemberName();
            loan[2] = loanlist.get(i).getBookTitle();
            loan[3] = String.valueOf(loanlist.get(i).isRenewStatus());
            loan[4] = loanlist.get(i).getLoanDate();
            loan[5] = String.valueOf(loanlist.get(i).getDeadline());
            loan[6] = String.valueOf(loanlist.get(i).isExtension());
            export.add(loan);
        }
        csvwriter.writeCSV(export, "loan.csv");
    }
    
}