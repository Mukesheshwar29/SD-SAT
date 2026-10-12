package com.sports.highlevel.model;

public record Score(
        Long matchId,
        String team1,
        int team1Score,
        String team2,
        int team2Score,
        String status
) {}
