package Library;

import java.util.*;

import Book.*;
import Loan.*;
import Member.*;

public class LibManager {
	ListMaker lm = new ListMaker();
	List<Member> members = lm.memberlist();
	List<Book> books = lm.booklist();
	List<Loan> lonas = lm.loanlist();
	MemFunc memf = new MemFunc();
	BookFunc bookf = new BookFunc();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		LibManager lm2 = new LibManager();
		lm2.start();
	}

	public void start() throws Exception {
		int select;

		while (true) {
			System.out.println("\n<도서 관리 프로그램 시작>\n0. 프로그램 종료\t1. 회원 관리\t2. 도서 관리\t3.(사용불가) 대출 관리 ");
			System.out.println("3번. 대출 관리 서비스는 성능 개선 작업으로 인해 임시적으로 사용이 중단됩니다.");
			select = sc.nextInt();

			switch (select) {
			// 프로그램 종료
			case 0: {

				System.out.println("프로그램이 종료되었습니다");
				
				break;
			}
			// 관리자로 시작
			case 1: {
				회원관리();
				break;
			}
			case 2: {
				도서관리();
				break;
			}
//			case 3: {
//				대출관리();
//				break;
//			}
			default: {
				System.out.println("0~3 사이로 다시 입력해주세요");
				continue;
			}
			}
			if (select == 0)
				break;
		}


	}

	public void 회원관리() {
		int select;
		while (true) {
			System.out.println("\n<회원 관리>\n0. 뒤로 가기\t1. 회원 조회\t2. 회원 추가\t3. 회원 수정\t4. 회원 삭제");
			select = sc.nextInt();

			switch (select) {
			// 뒤로 가기
			case 0: {
				break;
			}
			// 회원 조회
			case 1: {
				// 회원 다 호출
				memf.readMember(members);
				break;
			}
			// 회원 등록
			case 2: {
				memf.addMember(members);
				break;
			}
			// 회원 수정
			case 3: {
				memf.updateMember(members);
				break;
			}
			// 회원 삭제
			case 4: {
				memf.removeMember(members);
				break;
			}
			default: {
				System.out.println("0~4 사이로 다시 입력해주세요");
				continue;
			}
			}
			if (select == 0) {
				return;
			}
		}

	}

	public void 도서관리() {
		int select;
		while (true) {
			System.out.println("\n<도서 관리>\n0. 뒤로 가기\t1. 도서 조회\t2. 도서 추가\t3. 도서 수정\t4. 도서 삭제");
			select = sc.nextInt();

			switch (select) {
			case 0: {
				break;
			}
			case 1: {
				bookf.readBook(books);
				break;
			}
			case 2: {
				bookf.addBook(books);
				break;
			}
			case 3: {
				bookf.updateBook(books);
				break;
			}
			case 4: {
				bookf.removeBook(books);
				break;
			}
			case 5: {
				bookf.isAvailableBook(books);
				break;
			}
			default: {
				System.out.println("0~5 사이로 다시 입력해주세요");
				continue;
			}
			}
			if (select == 0) {
				return;
			}
		}

	}

}
