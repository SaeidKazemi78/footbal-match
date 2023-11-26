package ir.dayan.footballmatchproject.dto;

import ir.dayan.footballmatchproject.models.Match;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MatchDTO {
    private Long id;

    private TeamDTO firstTeam;

    private TeamDTO secondTeam;

    private TeamDTO winnerTeam;

    private LocalDateTime matchDate;

    private Boolean wasMatchEqual;


    //TODO we can use Mapstruct instead of this
    public static MatchDTO createMatchDTO(Match matchModel) {
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(matchModel.getId());
        matchDTO.setMatchDate(matchModel.getMatchDate());
        matchDTO.setFirstTeam(TeamDTO.createTeamDTO(matchModel.getFirstTeam()));
        matchDTO.setSecondTeam(TeamDTO.createTeamDTO(matchModel.getSecondTeam()));
        matchDTO.setWinnerTeam(ObjectUtils.isEmpty(matchModel.getWinnerTeam())
                ? null : TeamDTO.createTeamDTO(matchModel.getWinnerTeam()));
        matchDTO.setWasMatchEqual(matchModel.getWasMatchEqual());
        return matchDTO;
    }

}
