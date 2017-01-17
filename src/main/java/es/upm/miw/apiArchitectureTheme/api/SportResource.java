package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.SportAlreadyExistsFieldException;

public class SportResource {


	// POST **/sport   body="sport"
	public void createSport(String sportName) throws SportAlreadyExistsFieldException, InvalidSportFieldException {
		this.validateField(sportName);
		new SportController().createSport(sportName);
	}


	private void validateField(String sportName) throws InvalidSportFieldException {
		if (sportName == null || sportName.isEmpty()) {
			throw new InvalidSportFieldException(InvalidSportFieldException.ReasonCodes.NOT_EMPTY);
		}
	}


}
