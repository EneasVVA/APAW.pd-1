package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.ThemeController;
import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidThemeFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.ThemeListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

	// GET **/user
	public UserListWrapper userList() { return new UserController().userList();
	}

	// POST **/user   body="nick:email"
	public void createUser(String userName, String email) throws InvalidUserFieldException {
		this.validateFieldNick(userName);
		this.validateFieldEmail(email);
		new UserController().createUser(userName,email);
	}

	private void validateFieldEmail(String email) throws InvalidUserFieldException {
		if (email == null || email.isEmpty()) {
			throw new InvalidUserFieldException(InvalidUserFieldException.ReasonCodes.INVALID_EMAIL);
		}
	}

	private void validateFieldNick(String nick) throws InvalidUserFieldException {
		if (nick == null || nick.isEmpty()) {
			throw new InvalidUserFieldException(InvalidUserFieldException.ReasonCodes.INICK_ALREADY_EXISTS);
		}
	}

	// GET **themes/{id}/overage
	public OverageWrapper themeOverage(int themeId) throws NotFoundThemeIdException {
		OverageWrapper overageWrapper = new ThemeController().themeOverage(themeId);
		if (overageWrapper == null) {
			throw new NotFoundThemeIdException("" + themeId);
		} else {
			return overageWrapper;
		}
	}

}
