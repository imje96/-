package Book;

import java.util.*;
import Library.*;
import Member.*;

//대출/반납/연장/대출 가능 여부 확인, 책 정보 출력

public class BookFunc {
	ListMaker listMaker = new ListMaker();
	List<Book> books = listMaker.booklist();

	// 도서 조회
	public void readBook(List<Book> books) {
		for (Book book : books) {
			System.out.println("isbn: " + book.getIsbn());
			System.out.println("도서명: " + book.getTitle());
			System.out.println("작가명: " + book.getAuthor());
			System.out.println("출판일: " + book.getPublishDate());
			System.out.println("대출 가능 여부: " + book.getIsAvailable());
			System.out.println("---------------");
		}
	}

	// 도서 등록
	public void addBook(List<Book> books) {
		Scanner sc = new Scanner(System.in);

		System.out.println("등록할 isbn을 입력하세요: ");
		String isbn = sc.nextLine();
		System.out.println("등록할 도서명을 입력하세요: ");
		String title = sc.nextLine();
		System.out.println("등록할 작가명을 입력하세요: ");
		String author = sc.nextLine();
		System.out.println("등록할 출판일을 입력하세요: ");
		String publisherDate = sc.nextLine();

		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublishDate(publisherDate);
		book.setIsAvailable(true);

		books.add(book);

		System.out.println("도서가 등록되었습니다.");
	}

	// 도서 수정
	public void updateBook(List<Book> books) {
		Scanner sc = new Scanner(System.in);

		String bookIsbn;

		System.out.println("책의 isbn을 입력해주세요: ");
		bookIsbn = sc.nextLine();

//		boolean isFound;

		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getIsbn().equals(bookIsbn)) {
//				boolean isFound = true;

				System.out.println("새로운 isbn을 입력하세요: ");
				String newIsbn = sc.nextLine();
				book.setIsbn(newIsbn);

				System.out.println("새로운 도서명을 입력하세요: ");
				String newTitle = sc.nextLine();
				book.setTitle(newTitle);

				System.out.println("새로운 작가명을 입력하세요: ");
				String newAuthor = sc.nextLine();
				book.setAuthor(newAuthor);

				System.out.println("새로운 출판일을 입력하세요: ");
				String newPublishDate = sc.nextLine();
				book.setPublishDate(newPublishDate);

				books.set(books.indexOf(books.get(i)), book);

				for (Book book2 : books) {
					System.out.println(book2);

					System.out.println("정보 수정이 완료되었습니다.");
					break;
				}

			} else {
				System.out.println("해당 책이 조회되지 않습니다");
				System.out.println("수정할 책의 isbn을 다시 입력해주세요: ");
				bookIsbn = sc.nextLine();
				continue;
			}
		}
	}

	// 도서 삭제
	public void removeBook(List<Book> books) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 도서의 isbn을 입력하세요");
		String bookIsbn = sc.nextLine();
		boolean isRemoved = false;
		for (Book book : books) {
			if (book.getIsbn().equals(bookIsbn)) {
				books.remove(book);
				isRemoved = true;
				System.out.println("회원 정보가 삭제되었습니다.");
			} else {
				System.out.println("해당 책이 조회되지 않습니다");
				System.out.println("수정할 책의 isbn을 다시 입력해주세요: ");
				bookIsbn = sc.nextLine();
				continue;
			}
		}
	}

	public void isAvailableBook(List<Book> books) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대출여부를 확인할 도서의 isbn을 입력하세요");
		String bookIsbn = sc.nextLine();

		for (Book book : books) {
			if (book.getIsbn().equals(bookIsbn)) {
				if (book.getIsAvailable()==true) {
					System.out.println("해당 책은 대출 가능합니다.");
					//System.out.println("대출 하시겠습니까?")
					break;
				} else {System.out.println("해당 책은 대출 불가합니다.");
				break;
				}
			}
			else {
				System.out.println("해당 책이 조회되지 않습니다");
				System.out.println("수정할 책의 isbn을 다시 입력해주세요: ");
				bookIsbn = sc.nextLine();
				continue;
			}
		}
	}
}

//	public void modifyBook2(List<Book> books) {
//		Scanner sc = new Scanner(System.in);
//		String bookIsbn;
//
//		while (true) {
//			System.out.println("책의 isbn을 입력해주세요: ");
//			bookIsbn = sc.nextLine();
//
//			// 입력받은 ID와 일치하는 회원 정보를 찾아서 수정함
//			boolean isFound;
//			for (Book book : books) {
//				if (book.getIsbn().equals(bookIsbn)) {
//					isFound = true;
//					break;
//				
//			} else {
//				System.out.println("해당 책이 없습니다. 다시 입력해주세요.");
//				continue;
//			}
//		}
//
//		for (Book book : books) {
//
//			if (book.getIsbn().equals(bookIsbn)) {
//				System.out.println("수정할 항목을 선택하세요");
//				System.out.println("0. 뒤로\t1. isbn\t2. 도서명 \t3. 작가명\t4. 출판일");
//				System.out.println(">>");
//				int choice = sc.nextInt();
//				sc.nextLine();
//
//				switch (choice) {
//				case 0: {
//					break;
//				}
//				case 1:
//					System.out.println("새로운 isbn을 입력하세요: ");
//					String newIsbn = sc.nextLine();
//					book.setIsbn(newIsbn);
//					break;
//				case 2:
//					System.out.println("새로운 도서명을 입력하세요: ");
//					String newTitle = sc.nextLine();
//					book.setTitle(newTitle);
//					break;
//				case 3:
//					System.out.println("새로운 작가명을 입력하세요: ");
//					String newAuthor = sc.nextLine();
//					book.setAuthor(newAuthor);
//					break;
//				case 4:
//					System.out.println("새로운 출판일을 입력하세요: ");
//					String newPublishDate = sc.nextLine();
//					book.setPublishDate(newPublishDate);
//
//					break;
//				default:
//					System.out.println("0에서 4 사이로 다시 입력해주세요.");
//					continue;
//				}
//				System.out.println("회원 정보를 정상적으로 수정했습니다.");
//				System.out.println(book.toString());
//				break;
//			}
//		}
//
//	}
//
//
//	}
