import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import service.*;
import entity.*;
import data.*;
import view.InputView;

public class Main {

    public static void main(String[] args) {

        // Manager에서 각 Entity 리스트를 갖고있다.
        UserService us = new UserService();
        BookService bs = new BookService();
        LoanService ls = new LoanService();

        // 입력
        //InputView iv = new InputView();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.회원관리  2.도서관리  3.종료");
            int menu = sc.nextInt();
            if (menu < 1 || menu > 3) {
                System.out.println("잘못된 입력입니다");
                continue;
            }
            if (menu == 1) {
                // 1. 회원관리
                while (true) {
                    System.out.println("0.뒤로  1.회원조회  2.회원등록  3.회원수정  4.회원삭제  5.삭제취소");
                    int userMenu = sc.nextInt();
                    if (userMenu < 0 || userMenu > 5) {
                        System.out.println("잘못된 입력입니다");
                        continue;
                    }
                    // 0. 뒤로
                    if (userMenu == 0) {
                        break;
                    }
                    // 1. 회원조회
                    if (userMenu == 1) {
                        us.printAllList();
                        continue;
                    }
                    // 2.회원 등록
                    if (userMenu == 2) {
                        System.out.println("등록할 회원 정보를 입력하세요");
                        System.out.print("이름 : ");
                        String name = sc.nextLine();
                        Date now = new Date();
                        String joinDate = new SimpleDateFormat("yyyyMMdd").format(now);
                        System.out.print("주소 : ");
                        String address = sc.nextLine();
                        System.out.print("폰번호 : ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("생일 : ");
                        String birthday = sc.nextLine();
                        User us = new User(id, name, joinDate, address, phoneNumber, birthday);
                        return us;
                        User us = iv.newMember(0);
                        us.addUser(us);
                        System.out.println("등록이 완료되었습니다!");
                        continue;
                    }
                    // 3.회원 수정
                    if (userMenu == 3) {
                        System.out.println("수정하고 싶은 회원의 id를 입력하세요");
                        int id = sc.nextInt();
                        System.out.print("이름 : ");
                        String name = sc.nextLine();
                        Date now = new Date();
                        String joinDate = new SimpleDateFormat("yyyyMMdd").format(now);
                        System.out.print("주소 : ");
                        String address = sc.nextLine();
                        System.out.print("폰번호 : ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("생일 : ");
                        String birthday = sc.nextLine();
                        User user = new User(id, name, joinDate, address, phoneNumber, birthday);
                        return user;
                        us.editMember(id, user);
                        System.out.println("수정이 완료되었습니다!");
                        continue;
                    }
                    // 4.회원 삭제
                    if (userMenu == 4) {
                        System.out.print("삭제하고 싶은 회원의 id를 입력하세요");
                        int id = sc.nextInt();
                        boolean check = us.deleteMember(id);
                        if (check) {
                            System.out.println("삭제가 완료되었습니다!");
                        } else if (!check) {
                            System.out.println("삭제할 회원이 없습니다!");
                        }
                        continue;
                    }
                    // 5.삭제 취소
                    if (userMenu == 5) {
                        boolean check = us.rollbackDelete();
                        if (!check) {
                            System.out.println("취소할 삭제 내역이 없습니다");
                            continue;
                        }
                        System.out.println("삭제 취소 되었습니다");
                        continue;
                    }
                }
            }
            // 2. 도서관리
            if (menu == 2) {
                while (true) {
                    System.out.println("0.뒤로  1.도서전체조회  2.대출가능도서조회  3.대출이력조회  4.대출신청  5.연장신청");
                    int BookMenu = sc.nextInt();
                    if (BookMenu < 0 || BookMenu > 5) {
                        System.out.println("잘못된 입력입니다");
                        continue;
                    }
                    // 0. 뒤로
                    if (BookMenu == 0) {
                        break;
                    }
                    // 1. 도서 전체 조회 (최근출간순)
                    if (BookMenu == 1) {
                        bs.printAllList();
                        continue;
                    }
                    // 2. 대출가능도서조회
                    if (BookMenu == 2) {
                        bs.searchBookByAvailable();
                        continue;
                    }
                    // 3. 대출이력조회
                    if (BookMenu == 3) {
                        System.out.println("본인 이름을 입력하세요");
                        String memberName = sc.next();
                        us.searchLoanByName(memberName);
                        continue;
                    }
                    // 4. 대출신청
                    if (BookMenu == 4) {
                        System.out.println("본인 이름을 입력하세요");
                        String memberName = sc.next();

                        System.out.println("대출 가능한 책 목록입니다");
                        us.searchBookByAvailable();

                        System.out.println("책 이름을 입력하세요.");
                        String bookName = sc.next();

                        String loanDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
                        Loan newLoan = new Loan(0, memberName, bookName, false, loanDate, 14, false);
                        ls.loanBook(newLoan);
                        bs.loanBook(bookName);
                        System.out.println("대출 완료 되었습니다");
                        continue;
                    }
                    // 5. 연장신청
                    if (BookMenu == 5) {
                        System.out.println("본인 이름을 입력하세요");
                        String memberName = sc.next();

                        if(ls.searchAvaliableRenew(memberName)) {
                            System.out.println("연장 신청 가능 목록입니다");
                            System.out.println("책 이름을 입력하세요.");
                            String bookName = sc.next();
                            if(ls.extendLoan(memberName, bookName)) {
                                System.out.println("연장 되었습니다");
                            } else {
                                System.out.println("연장할 책이 없습니다");
                            }
                        } else {
                            System.out.println("연장 신청 가능한 목록이 없습니다.");
                        }
                        continue;
                    }
                }
            }
            // 3. 종료
            if (menu == 3) {
                System.out.println("종료합니다");
                break;
            }
        }
        // 프로그램 종료시, 바뀐 데이터를 저장하고 마무리한다.
        // 강제종료 시는 저장이 되지 않고, 3번 메뉴를 통해 정상 종료해야한다.
        Exportlist el = new Exportlist();
        el.exportBook(bs.getList());
        el.exportUser(us.getList());
        el.exportLoan(ls.getList());
    }
}