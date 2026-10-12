# Round 2 – Low-Level Design

## Aim
Design and implement REST APIs for a live sports platform.

## Architecture
Client → REST Controller → Match Service → In-memory data

## APIs

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/matches?query=India` | Search matches |
| GET | `/api/matches/101` | Match details |
| GET | `/api/matches/101/score` | Live score |
| GET | `/api/matches/101/events` | Match events |
| PUT | `/api/matches/101/score` | Update score |
| GET | `/api/teams/1` | Team details |

## Run

```bash
mvn spring-boot:run
```

Server: `http://localhost:8080`

## Example

```bash
curl "http://localhost:8080/api/matches?query=India"
curl "http://localhost:8080/api/matches/101/score"
```
