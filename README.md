# book-library

A small REST API for managing a library of books, built with Spring Boot 3 and
Java 17.

## Stack

- **Spring Boot Web**: REST controller (`BookController`)
- **Spring Data JPA**: persistence (`BookRepository`, `Book` entity)
- **H2**: in-memory database, seeded on startup by `DataSeeder`

## Run

```bash
./mvnw spring-boot:run        # starts on http://localhost:8080
./mvnw test                   # run tests
```

## API

| Method | Path          | Description        |
|--------|---------------|--------------------|
| GET    | `/books`      | List all books     |
| GET    | `/books/{id}` | Get one book       |
| POST   | `/books`      | Create a book      |
| PUT    | `/books/{id}` | Update a book      |
| DELETE | `/books/{id}` | Delete a book      |

The H2 console is available at `/h2-console` while running.
