package com.sports.highlevel.service;

import com.sports.highlevel.model.Score;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class ScoreService {

    // In a production system this hot data would be backed by Redis.
    private final ConcurrentMap<Long, Score> cache = new ConcurrentHashMap<>();

    public Score getLiveScore(Long matchId) {
        return cache.computeIfAbsent(
                matchId,
                id -> new Score(id, "India", 246, "Australia", 241, "LIVE")
        );
    }

    public Score updateScore(Long matchId, Score score) {
        cache.put(matchId, score);
        return score;
    }
}
