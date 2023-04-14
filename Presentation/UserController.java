package presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import domain.model.User;
import domain.repository.UserRepository;

public class UserController {
    private UserRepository userRepository;

    private boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);

    private User recentDeletedUser = null;

    private User lastDeletedUser;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void printMenu() {
        while (!isExit) {
            System.out.println("1. 유저등록, 2. 유저목록, 3. 유저수정, 4. 유저삭제, 5. 삭제취소 0. 뒤로");
            int target = scanner.nextInt();
            if (target == 1) {
                addUser();
            } else if (target == 2) {
                printUserList();
            } else if (target == 3) {
                updateUser();
            } else if (target == 4) {
                removeUser();
            } else if (target == 5) {
                restoreUser();
            } else if (target == 0) {
                isExit = true;
            }
        }
    }

    public void addUser() {
        System.out.println("이름을 입력하세요");
        String name = scanner.next();
        System.out.println("나이를 입력하세요");
        int age = scanner.nextInt();
        System.out.println("주소를 입력하세요");
        String address = scanner.next();
        System.out.println("전화번호를 입력하세요");
        String number = scanner.next();
        System.out.println("생년월일을 입력하세요 (YYYY/MM/DD)");
        String birthDay = scanner.next();
        LocalDate birthDate = LocalDate.parse(birthDay);
        LocalDate joinDate = LocalDate.now();

        userRepository.addUser(new User(name,age,address,number,birthDate, joinDate));
        System.out.println(userRepository.findAll());
    }

    public void printUserList() {
        System.out.println(userRepository.findAll());
    }
    
    public void removeUser() {
        System.out.println("몇 번 id 삭제?");
        int target = scanner.nextInt();

        recentDeletedUser = userRepository.findById(target);
        userRepository.deleteUser(recentDeletedUser);
        System.out.println(target + " 이 지워졌습니다");
    }

    public void updateUser() {
        System.out.println("수정할 유저의 ID를 입력하세요");
        int id = scanner.nextInt();
        System.out.println("수정할 유저의 이름을 입력하세요");
        String name = scanner.next();
        User user = userRepository.findById(id);
        User editUser = null;
        
        if (userRepository.findById(id).getId() == id && 
                userRepository.findByName(name).getName().equals(name)) {
            editUser = user;
        }
        
        System.out.println("어떤 정보를 수정하시겠습니까?");
        System.out.println("1. 이름 2. 나이 3. 주소 4. 전화번호 5. 생일");
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                System.out.println("새로운 이름을 입력해주세요");
                String newName = scanner.next();
                editUser.setName(newName);
                userRepository.updateUser(editUser);
                break;
            case 2:
                System.out.println("새로운 나이를 입력해주세요");
                int newAge = scanner.nextInt();
                editUser.setAge(newAge);;
                userRepository.updateUser(editUser);
                break;
            case 3:
                System.out.println("새로운 주소를 입력하세요");
                String newAddress = scanner.next();
                editUser.setAddress(newAddress);;
                userRepository.updateUser(editUser);
                break;
            case 4:
                System.out.println("새로운 번호를 입력하세요");
                String newNumber = scanner.next();
                editUser.setNumber(newNumber);;
                userRepository.updateUser(editUser);
                break;
            case 5:
                System.out.println("새로운 생일을 입력하세요");
                String birthDate = scanner.next();
                DateTimeFormatter sFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate newBirthday = LocalDate.parse(birthDate, sFormat);
                editUser.setBirthDate(newBirthday);
                userRepository.updateUser(editUser);
                break;
            default:
                System.out.println("잘못된 입력입니다");
                break;
        }
        // 파일에 넣어주기
        
        
    }
    public void deleteUser() {
        System.out.println("삭제할 ID를 입력해 주세요");
        int deleteTarget = scanner.nextInt();
        
        lastDeletedUser = userRepository.findById(deleteTarget);
        userRepository.deleteUser(lastDeletedUser);
        System.out.println(deleteTarget + "번 ID가 삭제되었습니다");
        
    }
    
    
    public void restoreUser() {
        userRepository.addUser(recentDeletedUser);
        System.out.println("id : " + recentDeletedUser.getId() + "인 유저가 복구되었습니다.");
    }

    public void exit() {

    }
}
