package Member;

import java.util.List;
import java.util.Scanner;
import data.ListMaker;
import entity.User;

public class MemFunc {

    // 파일에서 읽어온 회원 정보 리스트가
    ListMaker listMaker = new ListMaker();
    List<User> members = listMaker.memberlist();

    // 회원 조회
    public void memberList(List<User> members) {
        for (User member : members) {
            System.out.println("ID: " + member.getId());
            System.out.println("Name: " + member.getName());
            System.out.println("Address: " + member.getAddress());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            System.out.println("Birthday: " + member.getBirthday());
            System.out.println("---------------");
        }
    }

    // 회원 등록
    public void addMember(List<User> members) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ID : ");
        String id = sc.nextLine();
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("주소 : ");
        String address = sc.nextLine();
        System.out.println("전화번호 : ");
        String phoneNumber = sc.nextLine();
        System.out.println("생년월일(yyyy/MM/dd) : ");
        String birthday = sc.nextLine();

        User mem = new User();
        mem.setId(id);
        mem.setName(name);
        mem.setAddress(address);
        mem.setPhoneNumber(phoneNumber);
        mem.setBirthday(birthday);

        members.add(mem);

        System.out.println("회원이 등록되었습니다.");
    }

    // 회원 수정
    public void modifyMember(List<User> members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 회원의 ID를 입력해주세요: ");
        String memberID = sc.nextLine();

        // 입력받은 ID와 일치하는 회원 정보를 찾아서 수정함
        boolean isModified = false;
        for (User mem : members) {
            if (mem.getId().equals(memberID)) {
                System.out.println("수정할 항목을 선택하세요");
                System.out.println("1. 이름\t2. 주소\t3. 전화번호\t4. 생년월일");
                System.out.println(">>");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("새로운 이름을 입력하세요: ");
                        String newName = sc.nextLine();
                        mem.setName(newName);
                        break;
                    case 2:
                        System.out.println("새로운 주소를 입력하세요: ");
                        String newAdd = sc.nextLine();
                        mem.setAddress(newAdd);
                        break;
                    case 3:
                        System.out.println("새로운 전화번호를 입력하세요: ");
                        String newNum = sc.nextLine();
                        mem.setPhoneNumber(newNum);
                        break;
                    case 4:
                        System.out.println("새로운 생년월일을 입력하세요: ");
                        String newBirth = sc.nextLine();
                        mem.setBirthday(newBirth);
                        break;
                    default:
                        System.out.println("잘못 선택했습니다.");
                        break;
                }
                System.out.println("회원 정보를 정상적으로 수정했습니다.");
                System.out.println(mem.toString());
                isModified = true;
                break;
            }
        }


    }

    // 회원 삭제
    public void removeMember(List<User> members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 회원의 ID를 입력하세요");
        String memberID = sc.nextLine();
        boolean isRemoved = false;
        for (User mem : members) {
            if (mem.getId().equals(memberID)) {
                members.remove(mem);
                isRemoved = true;
                System.out.println("회원 정보가 삭제되었습니다.");
            }
        }
    }

    public void cancelRemove(List<User> members) {

    } // 삭제 취소
    @Override
    public String toString() {
        return "MemFunc [members=" + members + "]";
    }
    
//    @Override
//    public String toString() {
//        return String.format("Member{id='%s', name='%s', address='%s', phoneNumber='%s', birthDay='%s'}",
//                id, name, address, phoneNumber, birthDay);
//    }

}
