package com.sports.lowlevel.service;

import com.sports.lowlevel.model.Match;
import com.sports.lowlevel.model.Score;
import com.sports.lowlevel.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    public List<Match> searchMatches(String query) {
        return List.of(
                new Match(101L, "India", "Australia", "LIVE")
        );
    }

    public Match getMatch(Long id) {
        return new Match(id, "India", "Australia", "LIVE");
    }

    public Score getScore(Long id) {
        return new Score(245, 241);
    }

    public Score updateScore(Long id, Score score) {
        return score;
    }

    public List<String> getEvents(Long id) {
        return List.of(
                "10:32 - India scored 4 runs",
                "10:34 - Wicket",
                "10:36 - India scored 2 runs"
        );
    }

    public Team getTeam(Long id) {
        return new Team(id, "India", List.of("Player 1", "Player 2", "Player 3"));
    }
}
