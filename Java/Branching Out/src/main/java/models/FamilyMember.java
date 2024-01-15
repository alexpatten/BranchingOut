package models;

import java.sql.Date;

public class FamilyMember {
	private int memberID;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String relationship;
    private String gender;
    private String profilePicture;
    private User user;
    private Family family;
}
