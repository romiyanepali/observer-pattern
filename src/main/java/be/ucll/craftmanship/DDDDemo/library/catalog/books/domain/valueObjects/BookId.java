package be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects;

import org.springframework.util.Assert;

import java.util.UUID;

public record BookId(UUID id) {

    public BookId {
        Assert.notNull(id, "BookId cannot be null");
    }

    public BookId() {
        this(UUID.randomUUID());
    }
}
