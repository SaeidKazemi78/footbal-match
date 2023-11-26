package ir.dayan.footballmatchproject;

import ir.dayan.footballmatchproject.models.Team;
import ir.dayan.footballmatchproject.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballMatchProjectApplication implements CommandLineRunner {

    @Autowired
    private TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(FootballMatchProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.setName("استقلال");
        team1.setPlayerCount(23);
        team1.setWasAlreadyParticipant(false);


        team2.setName("سپاهان");
        team2.setPlayerCount(44);
        team2.setWasAlreadyParticipant(false);


        team3.setName("پرسپولیس");
        team3.setPlayerCount(67);
        team3.setWasAlreadyParticipant(false);


        team4.setName("ملوان");
        team4.setPlayerCount(90);
        team4.setWasAlreadyParticipant(false);


        teamRepository.saveAndFlush(team1);
        teamRepository.saveAndFlush(team2);
        teamRepository.saveAndFlush(team3);
        teamRepository.saveAndFlush(team4);

    }
}
