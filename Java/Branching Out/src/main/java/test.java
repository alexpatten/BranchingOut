import models.User;

public class test {
	public static void main(String[] args) {
		int myId = User.getUserIdByUsernameAndPassword("apatten", "password");
		System.out.println(myId);
	}
}
