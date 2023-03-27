package Library;

import java.util.ArrayList;
import java.util.List;

import Book.Book;
import Loan.Loan;
import Member.Member;

public class Exportlist {
	
	CSVWriter csvwriter = new CSVWriter();
	
	public void exportMember(List<Member> memberlist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"id", "name", "address", "phoneNumber", "birthday", "age", "joinDate"};
		export.add(index);
		for(int i=0; i<memberlist.size(); i++) {
			String[] member = new String[7];
			member[0] = String.valueOf(memberlist.get(i).getId());
			member[1] = memberlist.get(i).getName();
			member[2] = memberlist.get(i).getAddress();
			member[3] = memberlist.get(i).getPhoneNumber();
			member[4] = memberlist.get(i).getBirthday();
			member[5] = String.valueOf(memberlist.get(i).getAge());
			member[6] = memberlist.get(i).getJoinDate();
			export.add(member);
		}
		csvwriter.writeCSV(export, "member.csv");
	}
	
	public void exportBook(List<Book> booklist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"isbn", "title", "author", "publishDate", "isAvailable"};
		export.add(index);
		for(int i=0; i<booklist.size(); i++) {
			String[] book = new String[5];
			book[0] = String.valueOf(booklist.get(i).getIsbn());
			book[1] = booklist.get(i).getTitle();
			book[2] = booklist.get(i).getAuthor();
			book[3] = booklist.get(i).getPublishDate();
			book[4] = String.valueOf(booklist.get(i).getIsAvailable());
			export.add(book);
		}
		csvwriter.writeCSV(export, "book.csv");
	}
	
	public void exportLoan(List<Loan> loanlist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"id", "bookTitle", "loanDate", "dueDate", "renewStatus"};
		export.add(index);
		for(int i=0; i<loanlist.size(); i++) {
			String[] loan = new String[7];
			loan[0] = String.valueOf(loanlist.get(i).getId());
			loan[1] = loanlist.get(i).getBookTitle();
			loan[2] = loanlist.get(i).getLoanDate();
			loan[3] = loanlist.get(i).getDueDate();
			loan[4] = String.valueOf(loanlist.get(i).getIsRenewStatus());
			export.add(loan);
		}
		
		
		csvwriter.writeCSV(export, "loan.csv");
	}
	
}