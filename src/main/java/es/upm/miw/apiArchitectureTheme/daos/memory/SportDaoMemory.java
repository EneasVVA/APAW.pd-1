package es.upm.miw.apiArchitectureTheme.daos.memory;

import es.upm.miw.apiArchitectureTheme.daos.SportDao;
import es.upm.miw.apiArchitectureTheme.entities.Sport;

import java.util.HashMap;
import java.util.Map;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	private final Map<Integer, Sport> map;

	public SportDaoMemory() {
		this.setMap(map = new HashMap<Integer, Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public Sport getSport(String sportName) {
		for(Sport sport : map.values()) {
			if(sport.getSport().equals(sportName))
				return sport;
		}
		return null;
	}
}