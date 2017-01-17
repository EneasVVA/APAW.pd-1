package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

	// GET **/user
	public UserListWrapper userList() { return new UserController().userList();
	}

	// POST **/user   body="nick:email"
	public void createUser(String userName, String email) throws InvalidUserFieldException {
		try {
			this.validateField(userName);
		} catch (InvalidUserFieldException e) {
			throw new InvalidUserFieldException(InvalidUserFieldException.ReasonCodes.NICK_MANDATORY);
		}
		try {
			this.validateField(email);
		} catch (InvalidUserFieldException e) {
			throw new InvalidUserFieldException(InvalidUserFieldException.ReasonCodes.INVALID_EMAIL);
		}
		new UserController().createUser(userName,email);
	}

	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException();
		}
	}


	public UserListWrapper userListBySport(String sport) throws InvalidSportFieldException {
		return new UserController().userListBySport(sport);
	}


	public void addSport(String nick, String sportname) throws InvalidSportFieldException {
		new UserController().addSport(nick, sportname);


	}
}
