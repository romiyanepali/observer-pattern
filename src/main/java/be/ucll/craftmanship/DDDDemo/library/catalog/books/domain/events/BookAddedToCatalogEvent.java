package be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.events;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.Book;
import be.ucll.craftmanship.DDDDemo.library.shared.utils.Event;

import java.sql.Timestamp;

public class BookAddedToCatalogEvent implements Event {
    private final Book book;
    private Timestamp timestamp;

    public BookAddedToCatalogEvent(Book book) {
        this.book = book;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Book getBook() {
        return book;
    }

    @Override
     public Timestamp getTimeStamp() {
        return timestamp;
    }
}
