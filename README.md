# BoxOffice: Catalog Service

A simple Spring Boot REST API, packaged as a Docker image and run as a container with its port published.

It is the first piece of **BoxOffice**, a future ticketing platform for live shows. What comes next is planned in
[FUTURE_FEATURES.md](FUTURE_FEATURES.md).

> Versão em português: [README.pt-BR.md](README.pt-BR.md)

## The challenge

| Requirement | Where to find it |
|---|---|
| Spring Boot REST API with a GET endpoint that returns static data | [`ShowController`](src/main/java/com/boxoffice/catalog/controller/ShowController.java): `GET /api/v1/shows` |
| Valid Dockerfile at the project root | [`Dockerfile`](Dockerfile) |
| Image built and container running with its port published | [Step by step](#step-by-step), steps 1 to 3 |
| API tested with Postman | [`postman/`](postman) collection, [step 4](#step-by-step) |

## Tech stack

Java 21 · Spring Boot 4.1 · Spring Data JPA · H2 (in-memory) · Maven · Docker · Postman

## Project structure

```text
.
├── Dockerfile
├── pom.xml
├── src/main/java/com/boxoffice/catalog/
│   ├── CatalogServiceApplication.java
│   ├── controller/ShowController.java   # GET /api/v1/shows
│   ├── model/Show.java                  # JPA entity mapped to the shows table
│   └── repository/ShowRepository.java   # Spring Data JPA repository
├── src/main/resources/
│   ├── application.yml
│   ├── schema.sql                       # creates the shows table on startup
│   └── data.sql                         # example shows inserted on startup
└── postman/                             # Postman collection
```

## API

`GET /api/v1/shows` returns every show in the database, earliest first.

The data comes from [`data.sql`](src/main/resources/data.sql). Spring Boot loads it into an in-memory H2 database every
time the application starts, so there is no database to install. Edit that file to change what the API returns.

```json
[
  {
    "id": "neon-harbor-electric-tides-sao-paulo",
    "title": "Electric Tides Tour",
    "performer": "Neon Harbor",
    "category": "CONCERT",
    "venue": "Harbor Arena",
    "city": "São Paulo",
    "startsAt": "2026-11-28T21:00:00-03:00",
    "startingPrice": 180.00,
    "currency": "BRL"
  }
]
```

## Step by step

You only need Docker. Java and Maven run inside the image build.

**1. Build the image** from the `Dockerfile` at the project root:

```bash
docker build -t boxoffice/catalog-service .
```

The Dockerfile has two stages. The first compiles the jar with Maven and the JDK. The second copies only that jar
into a smaller image with just a Java runtime.

**2. Run the container**, publishing the application's port:

```bash
docker run -d --name catalog-service -p 8080:8080 boxoffice/catalog-service
```

`-p <host-port>:<container-port>` connects a port on your machine to the port the application listens on inside the
container, which is `8080`. With `-p 9090:8080` the same API would be reached at `http://localhost:9090`.

**3. Check that it is running:**

```bash
docker ps
```

**4. Test it** in Postman (or a browser) with `GET http://localhost:8080/api/v1/shows`. You can also import
[`postman/boxoffice.postman_collection.json`](postman/boxoffice.postman_collection.json), which already has the
request and checks that it responds with `200 OK` and a list of shows.

**5. Stop and remove the container:**

```bash
docker rm -f catalog-service
```

To run it without Docker: `./mvnw spring-boot:run`.

## What's next

Tests, more endpoints, more services, messaging with Kafka and RabbitMQ, observability and CI/CD are planned in
[FUTURE_FEATURES.md](FUTURE_FEATURES.md).
