package ir.dayan.footballmatchproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "tbl_team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "player_count")
    private int playerCount;

    @Column(name = "plays")
    private int plays;

    @Column(name = "win_count")
    private int winCount;

    @Column(name = "lost_count")
    private int lostCount;

    @Column(name = "equality_count")
    private int equalityCount;

    @Column(name = "score")
    private int score;

    @Column(name = "was_already_participant")
    private Boolean wasAlreadyParticipant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
