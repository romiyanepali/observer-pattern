package be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects;

import org.hibernate.validator.internal.constraintvalidators.hv.ISBNValidator;

public record Isbn(String value) {
    private static final ISBNValidator validator = new ISBNValidator();

    public Isbn {
        if (!validator.isValid(value, null)) {
            throw new IllegalArgumentException("Invalid ISBN: " + value);
        }
    }
}
