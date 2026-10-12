package com.sports.lowlevel.model;

public record Match(
        Long id,
        String team1,
        String team2,
        String status
) {}
