import models.User;

public class test {
	public static void main(String[] args) {
		boolean userExists = User.verifyUsername("aaa");
		if(userExists == true) {
			System.out.println(userExists);
		}
		else { System.out.println(userExists); }
	}
}
