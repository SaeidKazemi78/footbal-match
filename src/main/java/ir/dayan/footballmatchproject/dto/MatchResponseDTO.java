package ir.dayan.footballmatchproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDTO {

    private String champTeamName;

    private List<MatchDTO> matches;
}
