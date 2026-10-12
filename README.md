# Round 3 – High-Level System Design

## Aim
Design a scalable live sports platform capable of handling millions of users during major matches.

## Architecture

```text
Millions of Users
       |
       v
   CDN / DNS
       |
       v
 Load Balancer
       |
       v
  API Gateway
       |
       +-------------------------------+
       |        Microservices          |
       |                               |
       | Match | Score | Team | User   |
       +---------------+---------------+
                       |
             +---------+---------+
             |                   |
             v                   v
        Redis Cache          Kafka/Event Bus
             |                   |
             v                   v
        PostgreSQL        Score Processor
                                 |
                                 v
                       WebSocket / SSE
                                 |
                                 v
                         Connected Users
```

## Scalability

- Horizontal scaling of stateless services
- Load balancing
- Redis for hot live-score data
- Kafka for asynchronous score events
- PostgreSQL read replicas
- CDN for static content
- WebSocket/SSE for real-time updates
- Auto-scaling during high traffic

## Implementation Note

This project contains a runnable Spring Boot demonstration of the score service, cache layer, event publishing boundary, and real-time notification boundary. Redis, Kafka, WebSocket/SSE, load balancers and database replicas are represented as architectural components because the round focuses on high-level system design.

## Run

```bash
mvn spring-boot:run
```

Server: `http://localhost:8080`

## Test

```bash
curl http://localhost:8080/api/matches/101/score
```

Update:

```bash
curl -X PUT http://localhost:8080/api/matches/101/score ^
  -H "Content-Type: application/json" ^
  -d "{"matchId":101,"team1":"India","team1Score":247,"team2":"Australia","team2Score":241,"status":"LIVE"}"
```
