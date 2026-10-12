package com.sports.lowlevel.model;

import java.util.List;

public record Team(
        Long id,
        String name,
        List<String> players
) {}
