package Member;

import java.time.*;
import java.time.format.*;
import java.util.List;
import java.util.Scanner;
import Library.ListMaker;

public class MemFunc {

	// 파일에서 읽어온 회원 정보 리스트가
	ListMaker listMaker = new ListMaker();
	List<Member> members = listMaker.memberlist();

	// 회원 조회
	public void readMember(List<Member> members) {
		for (Member member : members) {
			System.out.println("ID: " + member.getId());
			System.out.println("이름: " + member.getName());
			System.out.println("주소: " + member.getAddress());
			System.out.println("전화번호: " + member.getPhoneNumber());
			System.out.println("생년월일: " + member.getBirthday());
			System.out.println("나이: " + member.getAge());
			System.out.println("등록일자: " + member.getJoinDate());
			System.out.println("---------------");
		}
	}

	// 회원 등록
	public void addMember(List<Member> members) {
		Scanner sc = new Scanner(System.in);

		System.out.println("등록할 ID를 입력하세요: ");
		String id = sc.nextLine();
		System.out.println("등록할 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.println("등록할 주소를 입력하세요: ");
		String address = sc.nextLine();
		System.out.println("등록할 전화번호를 입력하세요: ");
		String phoneNumber = sc.nextLine();
		System.out.println("등록할 생년월일(yyyy/MM/dd)을 형식에 맞춰 입력해주세요 : ");
		String birthday = sc.nextLine();
		// 생년월일을 입력받으면 나이가 자동으로 입력되게 추가
		LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		LocalDate currentDate = LocalDate.now();
		int age = Period.between(birthDate, currentDate).getYears();
		System.out.println("등록일 : ");
		String joinDate = sc.nextLine();

		Member mem = new Member();
		mem.setId(id);
		mem.setName(name);
		mem.setAddress(address);
		mem.setPhoneNumber(phoneNumber);
		mem.setBirthday(birthday);
		mem.setAge(age);
		mem.setJoinDate(joinDate);

		members.add(mem);

		System.out.println("회원이 등록되었습니다.");
	}

	// 회원 수정
	public void updateMember(List<Member> members) {
		Scanner sc = new Scanner(System.in);

		String memberID;

		System.out.println("수정할 회원의 ID를 입력하세요: ");
		memberID = sc.nextLine();

		for (int i = 0; i < members.size(); i++) {
			Member mem = members.get(i);
			if (mem.getId().equals(memberID)) {
//				boolean isFound = true;

				System.out.println("수정할 이름을 입력하세요: ");
				String newName = sc.nextLine();
				mem.setName(newName);

				System.out.println("수정할 주소를 입력하세요: ");
				String newAddress = sc.nextLine();
				mem.setAddress(newAddress);

				System.out.println("수정할 휴대폰 번호를 입력하세요(010-0000-0000): ");
				String newPhoneNumber = sc.nextLine();
				mem.setPhoneNumber(newPhoneNumber);

				System.out.println("수정할 생년월일(yyyy/MM/dd)을 형식에 맞춰 입력하세요: ");
				String newBirthday = sc.nextLine();
				mem.setBirthday(newBirthday);
				// 생년월일을 입력받으면 나이가 자동으로 입력되게 추가
				LocalDate birthDate = LocalDate.parse(mem.getBirthday(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				LocalDate currentDate = LocalDate.now();
				int age = Period.between(birthDate, currentDate).getYears();
				mem.setAge(age);

				System.out.println("수정할 가입일을 입력하세요: ");
				String newJoinDate = sc.nextLine();
				mem.setJoinDate(newJoinDate);

				members.set(members.indexOf(members.get(i)), mem);

//				for (Member member : members) {
//					System.out.println(member);

				System.out.println("정보 수정이 완료되었습니다.");
				break;
			} else {
				System.out.println("회원이 조회되지 않습니다");
				System.out.println("수정할 회원의 ID를 다시 입력해주세요: ");
				memberID = sc.nextLine();
				continue;

			}

		}
	}

	// 회원 삭제
	public void removeMember(List<Member> members) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 회원의 ID를 입력하세요");
		String memberID = sc.nextLine();
		boolean isRemoved = false;
		for (Member mem : members) {
			if (mem.getId().equals(memberID)) {
				members.remove(mem);
				isRemoved = true;
				System.out.println("회원 정보가 삭제되었습니다.");
			}
			System.out.println("회원정보가 조회되지 않습니다");
			System.out.println("조회할 회원의 ID를 다시 입력해주세요: ");
			memberID = sc.nextLine();
			continue;
		}
	}

	@Override
	public String toString() {
		return "MemFunc [members=" + members + "]";
	}

}
