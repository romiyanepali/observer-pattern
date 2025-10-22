package be.ucll.craftmanship.DDDDemo.library.catalog.copies.application;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.application.BookSearchService;
import be.ucll.craftmanship.DDDDemo.library.catalog.copies.commands.RegisterBookCopyCommand;
import be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain.Copy;
import be.ucll.craftmanship.DDDDemo.library.catalog.copies.infrastructure.CopyRepository;
import org.springframework.stereotype.Service;

@Service
public class CopyCommandHandler {
    private final CopyRepository copyRepository;

    public CopyCommandHandler(CopyRepository copyRepository, BookSearchService bookSearchService) {
        this.copyRepository = copyRepository;
    }

    public Copy handle(RegisterBookCopyCommand command) {
        var newCopy = new Copy(command.barCode(), command.bookId());
        return copyRepository.save(newCopy);
    }
}
