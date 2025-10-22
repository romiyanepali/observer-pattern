package be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.events;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.Book;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.Isbn;
import be.ucll.craftmanship.DDDDemo.library.shared.utils.Event;

import java.sql.Timestamp;

public class BookRemovedFromCatalogEvent implements Event {
    private final Book book;
    private final Timestamp timestamp;

    public BookRemovedFromCatalogEvent(Book book) {
        this.book = book;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Isbn getIsbn() {
        return book.getIsbn();
    }

    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public Timestamp getTimeStamp() {
        return timestamp;
    }
}
