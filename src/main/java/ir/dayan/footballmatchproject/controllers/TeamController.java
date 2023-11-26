package ir.dayan.footballmatchproject.controllers;

import ir.dayan.footballmatchproject.dto.ResponseDTO;
import ir.dayan.footballmatchproject.dto.TeamDTO;
import ir.dayan.footballmatchproject.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {


    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<Void>> registerTeam(@RequestBody TeamDTO teamDTO) {
        teamService.registerTeam(teamDTO);
        return ResponseEntity.ok(ResponseDTO.successful(null));
    }
}
