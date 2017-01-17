package es.upm.miw.apiArchitectureTheme.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {
    private int id;

    private String nick;
    private String email;
    private List<Sport> sport = new ArrayList<Sport>();

    public User(String nick) {
        this.nick = nick;
    }


    public int getId() { return id; }

	public String getNick() {
        return nick;
    }


    public void addSport(Sport sport) { this.sport.add(sport); }

	public List<Sport> getSport() {
		return sport;
	}


    public void setId(int id) {
        this.id = id;
    }

	public void setNick() { this.nick = nick; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*
    public void setSport() { this.sport = sport; }
*/

	@Override
	public String toString() {
		return "Theme [ id="+id+" nick=" + nick + ", sport=" + sport + "]";
	}


}
