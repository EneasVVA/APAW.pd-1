package es.upm.miw.apiArchitectureTheme.daos.memory;

import es.upm.miw.apiArchitectureTheme.daos.ThemeDao;
import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.entities.Theme;
import es.upm.miw.apiArchitectureTheme.entities.User;

import java.util.HashMap;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);

	}

}