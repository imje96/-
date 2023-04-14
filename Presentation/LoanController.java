
package presentation;

import java.util.Random;
import java.util.Scanner;
import domain.model.Loan;
import domain.repository.LoanRepository;


public class LoanController {

    private LoanRepository LoanRepository;
    
    private boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);
    
    private Loan recentDeletedLoan = null;
    
    public LoanController(LoanRepository LoanRepository) {
        this.LoanRepository = LoanRepository;
    }
    
    public void printMenu() {
        while (!isExit) {
            System.out.println("1. 유저등록, 2. 유저목록, 3. 유저수정, 4. 유저삭제, 5. 삭제취소 0. 뒤로");
            int target = scanner.nextInt();
            if (target == 1) {
                addUser();
            } else if (target == 2) {
                printUserList();
            } else if (target == 0) {
                isExit = true;
            } else if (target == 4) {
                removeUser();
            } else if (target == 5) {
                restoreUser();
            }
        }
    }
    
    public void printUserList() {
        System.out.println(LoanRepository.findAll());
    }
    
    public void addUser() {
        // 쭉 받고
        String name = String.valueOf(new Random().nextInt(1000));
        LoanRepository.addLoan(new Loan(name));
    }
    
    public void removeUser() {
        System.out.println("몇 번 id 삭제?");
        int target = scanner.nextInt();
        
        recentDeletedLoan = LoanRepository.findById(target);
        LoanRepository.deleteLoan(recentDeletedLoan);
        System.out.println(target + " 이 지워졌습니다");
    }
    
    public void updateUser() {
        
    }
    
    public void restoreUser() {
        LoanRepository.addLoan(recentDeletedLoan);
        System.out.println("id : " + recentDeletedLoan.getId() + "인 유저가 복구 됐어요");
    }
    
    public void exit() {
        
    }
}
