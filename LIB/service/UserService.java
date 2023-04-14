package domain;

import java.util.Collections;

import entity.Book;
import entity.User;

public class UserService extends User<User> {

	User forRollback = null;
	// list = ml.memberlist(); 가 있음

	public UserService() {
		// Makelist 클래스의 memberlist 메서드를 호출하여 반환된 리스트를 list 필드에 할당합니다.
		list = ul.userlist();
	}

	@Override
	public void printAllList() {
		Collections.sort(list); // id 기준으로 정렬
		for (User u : list) {
			System.out.println(m);
		}
	}

	// addMember(): 새로운 회원을 추가합니다.
	public void addMember(User User) {
		int id = list.get(list.size() - 1).getId() + 1;
		User.setId(id);
		list.add(User);
	}

	// editMember() : 회원수정
	public void editMember(int id, User User) {
		for (User user : list) {
			if (user.getId() == id) {
				list.set(list.indexOf(user), User);
				break;
			}
		}
	}

	// - deleteMember(): 회원을 삭제합니다.
	public boolean deleteMember(int id) {
		boolean result = false;
		for (User user : list) {
			if (user.getId() == id) {
				list.remove(user);
				forRollback = user;
				result = true;
				break;
			}
		}
		return result;
	}

	// rollbackdelete() : 삭제취소 ((추가사항))
	public boolean rollbackDelete() {
		boolean result = true;
		if (forRollback == null) {
			return false;
		}
		list.add(forRollback);
		forRollback = null;
		return result;
	}
}