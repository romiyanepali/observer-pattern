package be.ucll.craftmanship.DDDDemo.library.catalog.copies.commands;

import be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain.BarCode;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.BookId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RegisterBookCopyCommand(
        @NotNull BookId bookId,
        @Valid BarCode barCode) {
}
