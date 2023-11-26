package ir.dayan.footballmatchproject.repositories;

import ir.dayan.footballmatchproject.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT team.name FROM Team team WHERE team.score=(SELECT MAX(team.score) FROM Team team)")
    String readMostScoredTeam();
}
