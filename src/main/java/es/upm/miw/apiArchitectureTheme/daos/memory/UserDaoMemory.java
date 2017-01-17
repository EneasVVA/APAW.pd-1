package es.upm.miw.apiArchitectureTheme.daos.memory;

import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	private final Map<Integer, User> map;
	public UserDaoMemory() {
		this.setMap(map = new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);

	}

	@Override
	public User findByNick(String nick) {
		for(User user : map.values()) {
			if(user.getNick().equals(nick))
				return user;
		}
		return null;
	}
}