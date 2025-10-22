package be.ucll.craftmanship.DDDDemo.library.catalog.books.commands;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.Isbn;

public record AddBookToCatalogCommand (Isbn isbn){
}
