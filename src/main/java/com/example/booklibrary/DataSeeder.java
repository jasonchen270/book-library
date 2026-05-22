package com.example.booklibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BookRepository repo;

    public DataSeeder(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Book("The Pragmatic Programmer", "David Thomas", 1999, "Technology"));
        repo.save(new Book("Clean Code", "Robert C. Martin", 2008, "Technology"));
        repo.save(new Book("Designing Data-Intensive Applications", "Martin Kleppmann", 2017, "Technology"));
        repo.save(new Book("Dune", "Frank Herbert", 1965, "Sci-Fi"));
        repo.save(new Book("The Hitchhikers Guide to the Galaxy", "Douglas Adams", 1979, "Sci-Fi"));
        repo.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"));
        repo.save(new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "Fantasy"));
        repo.save(new Book("1984", "George Orwell", 1949, "Dystopian"));
    }
}
