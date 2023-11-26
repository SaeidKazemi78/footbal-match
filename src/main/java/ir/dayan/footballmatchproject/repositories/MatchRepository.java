package ir.dayan.footballmatchproject.repositories;

import ir.dayan.footballmatchproject.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("select match from Match  match ")
    List<Match> readMatches();

}
