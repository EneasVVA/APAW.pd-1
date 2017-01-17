package es.upm.miw.apiArchitectureTheme.daos;

import es.upm.miw.apiArchitectureTheme.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

    User findByNick(String nick);
}
