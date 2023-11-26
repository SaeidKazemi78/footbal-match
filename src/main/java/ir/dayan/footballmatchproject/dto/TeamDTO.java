package ir.dayan.footballmatchproject.dto;

import ir.dayan.footballmatchproject.models.Team;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamDTO {


    private long id;

    private String name;

    private int playerCount;

    private int plays;

    private int winCount;

    private int lostCount;

    private int equalityCount;

    private int score;

    private Boolean wasAlreadyParticipant;


    //TODO we can use Masptruct as mapper here
    public static TeamDTO createTeamDTO(Team teamModel) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(teamModel.getId());
        teamDTO.setName(teamModel.getName());
        teamDTO.setPlayerCount(teamModel.getPlayerCount());
        teamDTO.setPlays(teamModel.getPlays());
        teamDTO.setWinCount(teamModel.getWinCount());
        teamDTO.setLostCount(teamModel.getLostCount());
        teamDTO.setEqualityCount(teamModel.getEqualityCount());
        teamDTO.setScore(teamModel.getScore());
        teamDTO.setWasAlreadyParticipant(teamModel.getWasAlreadyParticipant());
        return teamDTO;
    }
}
