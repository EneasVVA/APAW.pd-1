package es.upm.miw.apiArchitectureTheme.daos.memory;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.daos.ThemeDao;
import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.daos.VoteDao;

public class DaoFactoryMemory extends DaoFactory {

	private ThemeDao themeDao;
	private VoteDao voteDao;
	private UserDao userDao;

	public DaoFactoryMemory() {
	}

	@Override
	public ThemeDao getThemeDao() {
		if (themeDao == null) {
			themeDao = new ThemeDaoMemory();
		}
		return themeDao;
	}

	@Override
	public VoteDao getVoteDao() {
		if (voteDao == null) {
			voteDao = new VoteDaoMemory();
		}
		return voteDao;
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoMemory();
		}
		return userDao;
	}

}
