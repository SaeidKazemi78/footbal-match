package ir.dayan.footballmatchproject.controllers;

import ir.dayan.footballmatchproject.dto.MatchResponseDTO;
import ir.dayan.footballmatchproject.dto.ResponseDTO;
import ir.dayan.footballmatchproject.services.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/match")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/start-match")
    public ResponseEntity<ResponseDTO<MatchResponseDTO>> startMatch() {
        return ResponseEntity.ok(ResponseDTO.successful(matchService.startMatches()));
    }
}
