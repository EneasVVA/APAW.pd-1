package es.upm.miw.apiArchitectureTheme.wrappers;

public class UserWrapper {
	private int id;

	private String nick;
	private String email;
	private int sport = 1;

/*
    private Sport sport;
*/


	public UserWrapper(int id, String nick, String email, int sport) {
		this.id = id;
		this.nick = nick;
		this.email = email;
		this.sport = sport;
	}


	public int getId() { return id; }

	public String getNick() {
		return nick;
	}

/*
	public Sport getSport() {
		return sport;
	}
*/

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

	@Override
	public String toString() {
		return "UserWrapper{" +
				"id=" + id +
				", nick='" + nick + '\'' +
				", email='" + email + '\'' +
				", sport=" + sport +
				'}';
	}

/*
    public void setSport() { this.sport = sport; }
*/



}
