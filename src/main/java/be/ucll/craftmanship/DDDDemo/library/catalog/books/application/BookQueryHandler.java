package be.ucll.craftmanship.DDDDemo.library.catalog.books.application;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.Book;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.infrastructure.BookRepository;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.queries.BookQuery;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BookQueryHandler {
    private final BookRepository bookRepository;

    public BookQueryHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> filterBooks(@Valid BookQuery query) {
        if (query.title() != null && query.publisher() != null) {
            return bookRepository.findByTitleContainingAndPublishersContaining(query.title(), query.publisher());
        } else if (query.title() != null) {
            return bookRepository.findByTitleContaining(query.title());
        } else if (query.publisher() != null) {
            return bookRepository.findByPublishersContaining(query.publisher());
        } else {
            return null;
        }
    }
}
