package com.sports.highlevel.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String publishScoreUpdate(Long matchId) {
        // Production design: publish to Kafka topic "score-updates".
        return "Score update published to event stream for match " + matchId;
    }

    public String sendRealtimeUpdate(Long matchId) {
        // Production design: WebSocket/SSE pushes the event to clients.
        return "Real-time update delivered to connected users for match " + matchId;
    }
}
