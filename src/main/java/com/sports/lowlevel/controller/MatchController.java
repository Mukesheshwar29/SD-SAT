package com.sports.lowlevel.controller;

import com.sports.lowlevel.model.Match;
import com.sports.lowlevel.model.Score;
import com.sports.lowlevel.model.Team;
import com.sports.lowlevel.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping("/matches")
    public List<Match> searchMatches(@RequestParam String query) {
        return service.searchMatches(query);
    }

    @GetMapping("/matches/{id}")
    public Match getMatch(@PathVariable Long id) {
        return service.getMatch(id);
    }

    @GetMapping("/matches/{id}/score")
    public Score getScore(@PathVariable Long id) {
        return service.getScore(id);
    }

    @GetMapping("/matches/{id}/events")
    public List<String> getEvents(@PathVariable Long id) {
        return service.getEvents(id);
    }

    @PutMapping("/matches/{id}/score")
    public Score updateScore(
            @PathVariable Long id,
            @RequestBody Score score) {
        return service.updateScore(id, score);
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable Long id) {
        return service.getTeam(id);
    }
}
