package be.ucll.craftmanship.DDDDemo.library.catalog.books.application;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.events.BookAddedToCatalogEvent;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.events.BookRemovedFromCatalogEvent;
import be.ucll.craftmanship.DDDDemo.library.shared.utils.Event;
import be.ucll.craftmanship.DDDDemo.library.shared.utils.EventPublisher;
import be.ucll.craftmanship.DDDDemo.library.shared.utils.Observer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BookEventObserver implements Observer {

    private EventPublisher eventPublisher;

    BookEventObserver(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostConstruct
    public void init() {
        this.eventPublisher.subscribe(this);
    }

@Override
public void onEvent(Event event) {
    switch (event) {
        case BookAddedToCatalogEvent bookEvent ->
            System.out.println("Book added to catalog: " + bookEvent.getBook().getTitle() +
                    " at " + bookEvent.getTimeStamp());
        case BookRemovedFromCatalogEvent removeEvent ->
            System.out.println("Book removed from catalog with ISBN: " + removeEvent.getIsbn());
        default ->
            System.out.println("event type received that doesn't concern us.");
    }
}
}
