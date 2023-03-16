package org.agoncal.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name= "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Undertaning quarkus", "Antonio", 2020, genre),
                new Book(2, "Practicing quarkus", "Antonio", 2020, genre),
                new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
                new Book(4, "Thinking Java", "Bruce Eckel", 1998, genre)
        );
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks()
                .stream().filter(book -> book.id == id)
                .findFirst();
    }
}
