package be.ucll.craftmanship.DDDDemo.library.catalog.copies.controllers;

import be.ucll.craftmanship.DDDDemo.library.catalog.copies.application.CopyCommandHandler;
import be.ucll.craftmanship.DDDDemo.library.catalog.copies.commands.RegisterBookCopyCommand;
import be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain.Copy;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/copies")
public class CopyController {

    private CopyCommandHandler copyCommandHandler;

    public CopyController(CopyCommandHandler copyCommandHandler) {
        this.copyCommandHandler = copyCommandHandler;
    }

    @GetMapping
    public Copy findCopy(UUID copyId) {
        return null;
    }

    @PostMapping
    public Copy registerCopy(@RequestBody @Valid RegisterBookCopyCommand command) {
        return copyCommandHandler.handle(command);

    }
}
