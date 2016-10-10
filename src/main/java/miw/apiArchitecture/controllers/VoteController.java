package miw.apiArchitecture.controllers;

import java.util.List;

import miw.apiArchitecture.daos.DaoFactory;
import miw.apiArchitecture.entities.Theme;
import miw.apiArchitecture.entities.Vote;
import miw.apiArchitecture.wrappers.VoteListWrapper;
import miw.apiArchitecture.wrappers.VoteWrapper;

public class VoteController {

	public boolean createVote(int themeId, int vote) {
		Theme theme = DaoFactory.getFactory().getThemeDao().read(themeId);
		if (theme != null) {
			DaoFactory.getFactory().getVoteDao().create(new Vote(vote, theme));
			return true;
		} else {
			return false;
		}
	}

	public VoteListWrapper voteList() {
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
		VoteListWrapper voteListWrapper = new VoteListWrapper();
		for (Vote vote : votes) {
			voteListWrapper.addVoteWrapper(new VoteWrapper(vote.getTheme().getName(),vote.getVote()));
		}
		return voteListWrapper;
	}

}
