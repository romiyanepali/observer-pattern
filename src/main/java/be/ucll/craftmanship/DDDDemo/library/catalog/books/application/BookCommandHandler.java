package be.ucll.craftmanship.DDDDemo.library.catalog.books.application;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.commands.AddBookToCatalogCommand;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.commands.RemoveBookFromCatalogCommand;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.Book;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.events.BookAddedToCatalogEvent;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.events.BookRemovedFromCatalogEvent;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.Isbn;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.infrastructure.BookRepository;
import be.ucll.craftmanship.DDDDemo.library.shared.utils.EventPublisher;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookCommandHandler {
    private final BookSearchService bookSearchService;
    private final BookRepository bookRepository;
    private final EventPublisher eventPublisher;


    public BookCommandHandler(BookSearchService bookSearchService, BookRepository bookRepository, EventPublisher eventPublisher) {
        this.bookSearchService = bookSearchService;
        this.bookRepository = bookRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Book handle(AddBookToCatalogCommand command) {
        var bookInformation = bookSearchService.search(command.isbn());
        var newBook = new Book(bookInformation.title(),
                                command.isbn(),
                                String.join(",", bookInformation.publishers()));
        var result = bookRepository.save(newBook);
        this.eventPublisher.publish(new BookAddedToCatalogEvent(result));
        return result;
    }

    @Transactional
    public boolean handle(RemoveBookFromCatalogCommand command) {
        var book = bookRepository.findBookByIsbn(new Isbn(command.Isbn()));
        if (book == null) {
            return false;
        }

        bookRepository.deleteBookById(book.getId());
        eventPublisher.publish(new BookRemovedFromCatalogEvent(book));
        return true;
    }
}
