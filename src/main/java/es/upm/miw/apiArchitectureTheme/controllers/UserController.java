package es.upm.miw.apiArchitectureTheme.controllers;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureTheme.wrappers.*;

import java.util.List;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail(), user.getSport().toString()));
		}
		return userListWrapper;
	}

	public void createUser(String nick, String email) {
		User user = new User(nick);
		user.setEmail(email);
		DaoFactory.getFactory().getUserDao().create(user);
	}

    public void addSport(String nick, String sportName) throws InvalidSportFieldException {
		SportController sportController = new SportController();
		Sport sport = sportController.getSport(sportName);
		DaoFactory.getFactory().getUserDao().findByNick(nick).addSport(sport);
    }

	public UserListWrapper userListBySport(String sportName) throws InvalidSportFieldException {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			SportController sportController = new SportController();
			Sport sport = sportController.getSport(sportName);
			if(user.getSport().contains(sport) )
				userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail(), user.getSport().toString()));
		}
		return userListWrapper;
	}

/*
	public OverageWrapper userOverage(int userId) {
		if (DaoFactory.getFactory().getUserDao().read(userId) == null) {
			return null;
		}
		List<Integer> voteValues = DaoFactory.getFactory().getVoteDao().findValueByUserId(userId);
		double total = 0;
		for (Integer value : voteValues) {
			total += value;
		}
		return new OverageWrapper(total / voteValues.size());
	}
*/

}
