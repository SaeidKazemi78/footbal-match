package ir.dayan.footballmatchproject.services;

import ir.dayan.footballmatchproject.dto.TeamDTO;
import ir.dayan.footballmatchproject.models.Team;
import ir.dayan.footballmatchproject.repositories.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void registerTeam(TeamDTO teamDTO) {
        //TODO we can use Mapping libraries like Mapstruct here
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setPlayerCount(teamDTO.getPlayerCount());
        team.setWasAlreadyParticipant(false);
        teamRepository.saveAndFlush(team);
    }

}
