package es.upm.miw.apiArchitectureTheme.controllers;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.daos.SportDao;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.SportAlreadyExistsFieldException;


public class SportController {


	public void createSport(String sportName) throws SportAlreadyExistsFieldException {
		SportDao sportDao = DaoFactory.getFactory().getSportDao();
		if(sportDao.getSport(sportName) != null)
			throw new SportAlreadyExistsFieldException(SportAlreadyExistsFieldException.ReasonCodes.ALREADY_EXISTS);
		DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
	}


	public Sport getSport(String sportName) throws InvalidSportFieldException {
		Sport sport = DaoFactory.getFactory().getSportDao().getSport(sportName);
		if(sport == null)
			throw new InvalidSportFieldException(InvalidSportFieldException.ReasonCodes.INVALID_NAME);
		return sport ;
	}


}
