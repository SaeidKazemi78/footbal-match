package ir.dayan.footballmatchproject.services;

import ir.dayan.footballmatchproject.dto.MatchDTO;
import ir.dayan.footballmatchproject.dto.MatchResponseDTO;
import ir.dayan.footballmatchproject.models.Match;
import ir.dayan.footballmatchproject.models.Team;
import ir.dayan.footballmatchproject.models.enums.MatchResultEnum;
import ir.dayan.footballmatchproject.repositories.MatchRepository;
import ir.dayan.footballmatchproject.repositories.TeamRepository;
import ir.dayan.footballmatchproject.utils.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {


    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    private final Integer WINNING_SCORE = 3;
    private final Integer EQUALITY_SCORE = 1;

    public MatchService(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public MatchResponseDTO startMatches() {

        //All register teams are 4 | It's not best practice to fetch all records  | It's just for test purposes
        List<Team> allRegisteredTeams = teamRepository.findAll();
        List<Integer> allTeamIds = allRegisteredTeams.stream().map(value -> Math.toIntExact(value.getId())).toList();
        List<int[]> specifiedMatches = RandomUtils.matchRandomGenerator(allTeamIds);

        Team firstTeam;
        Team secondTeam;
        for (int[] matches : specifiedMatches) {
            int firstTeamIndex = 0;
            int secondTeamIndex = 1;
            Match match = new Match();
            firstTeam = teamRepository.findById((long) matches[firstTeamIndex]).get();
            secondTeam = teamRepository.findById((long) matches[secondTeamIndex]).get();
            match.setFirstTeam(firstTeam);
            match.setSecondTeam(secondTeam);
            match.setMatchDate(LocalDateTime.now());

            //Set The Winner Randomly
            MatchResultEnum matchResultEnum = RandomUtils.getWinner();

            Team winner = null;

            if (matchResultEnum.equals(MatchResultEnum.FIRST_TEAM_WON)) {
                winner = firstTeam;
                match.setWinnerTeam(winner);
                firstTeam.setScore(firstTeam.getScore() + WINNING_SCORE);
                firstTeam.setWinCount(firstTeam.getWinCount() + 1);
                secondTeam.setLostCount(secondTeam.getLostCount() + 1);
            } else if (matchResultEnum.equals(MatchResultEnum.SECOND_TEAM_WON)) {
                winner = secondTeam;
                match.setWinnerTeam(winner);
                secondTeam.setScore(secondTeam.getScore() + WINNING_SCORE);
                secondTeam.setWinCount(secondTeam.getWinCount() + 1);
                firstTeam.setLostCount(firstTeam.getLostCount() + 1);
            } else {
                firstTeam.setScore(firstTeam.getScore() + EQUALITY_SCORE);
                secondTeam.setScore(secondTeam.getScore() + EQUALITY_SCORE);
                firstTeam.setEqualityCount(firstTeam.getEqualityCount() + 1);
                secondTeam.setEqualityCount(secondTeam.getEqualityCount() + 1);
                match.setWasMatchEqual(true);
            }

            firstTeam.setPlays(firstTeam.getPlays() + 1);
            secondTeam.setPlays(secondTeam.getPlays() + 1);
            firstTeam.setWasAlreadyParticipant(true);
            secondTeam.setWasAlreadyParticipant(true);

            if (!ObjectUtils.isEmpty(winner)) match.setWinnerTeam(winner);
            teamRepository.saveAndFlush(firstTeam);
            teamRepository.saveAndFlush(secondTeam);
            matchRepository.saveAndFlush(match);
        }

        MatchResponseDTO responseDTO = new MatchResponseDTO();
        responseDTO.setMatches(matchRepository.readMatches().stream().map(MatchDTO::createMatchDTO).collect(Collectors.toList()));
        responseDTO.setChampTeamName(teamRepository.readMostScoredTeam());
        return responseDTO;
    }

}
