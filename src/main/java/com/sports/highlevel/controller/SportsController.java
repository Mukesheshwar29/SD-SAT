package com.sports.highlevel.controller;

import com.sports.highlevel.model.Score;
import com.sports.highlevel.service.NotificationService;
import com.sports.highlevel.service.ScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SportsController {

    private final ScoreService scoreService;
    private final NotificationService notificationService;

    public SportsController(
            ScoreService scoreService,
            NotificationService notificationService) {
        this.scoreService = scoreService;
        this.notificationService = notificationService;
    }

    @GetMapping("/matches/{id}/score")
    public Score getScore(@PathVariable Long id) {
        return scoreService.getLiveScore(id);
    }

    @PutMapping("/matches/{id}/score")
    public String updateScore(
            @PathVariable Long id,
            @RequestBody Score score) {

        scoreService.updateScore(id, score);
        notificationService.publishScoreUpdate(id);
        return notificationService.sendRealtimeUpdate(id);
    }
}
