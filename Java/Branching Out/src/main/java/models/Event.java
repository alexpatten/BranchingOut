package models;

import java.sql.Date;
import java.sql.Time;

public class Event {
	private int eventID;
    private String eventName;
    private Date date;
    private Time time;
    private String location;
    private String description;
    private Family family;
}
