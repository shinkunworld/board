package model;
//3.로그인기능을 작성
public class LoginLogic {
	public boolean execute(User user) {
		if (user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
