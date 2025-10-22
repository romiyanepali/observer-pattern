package be.ucll.craftmanship.DDDDemo.library.catalog.books.controllers;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.application.BookCommandHandler;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.application.BookQueryHandler;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.commands.AddBookToCatalogCommand;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.Book;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.queries.BookQuery;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog/books")
public class CatalogBookController {

    private final BookCommandHandler commandHandler;
    private final BookQueryHandler queryHandler;

    public CatalogBookController(BookCommandHandler commandHandler, BookQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public List<Book> AllBooks() {
        return queryHandler.findAll();
    }

    @PostMapping
    public List<Book> FilterBooks(@RequestBody @Valid BookQuery query) {
        return queryHandler.filterBooks(query);
    }

    @PutMapping
    private void addBook(@RequestBody @Valid AddBookToCatalogCommand command) {
        commandHandler.handle(command);
    }

}
