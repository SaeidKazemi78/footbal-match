package ir.dayan.footballmatchproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "first_team")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team firstTeam;

    @JoinColumn(name = "second_team")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team secondTeam;

    @JoinColumn(name = "winner")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team winnerTeam;

    @Column(name = "match_date")
    private LocalDateTime matchDate;

    @Column(name = "was_match_equal")
    private Boolean wasMatchEqual;


}


