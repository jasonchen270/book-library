package com.example.booklibrary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Book> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/author/{author}")
    public List<Book> getByAuthor(@PathVariable String author) {
        return repo.findByAuthorIgnoreCase(author);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getByGenre(@PathVariable String genre) {
        return repo.findByGenreIgnoreCase(genre);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return repo.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book updated) {
        return repo.findById(id).map(book -> {
            book.setTitle(updated.getTitle());
            book.setAuthor(updated.getAuthor());
            book.setYear(updated.getYear());
            book.setGenre(updated.getGenre());
            return ResponseEntity.ok(repo.save(book));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
