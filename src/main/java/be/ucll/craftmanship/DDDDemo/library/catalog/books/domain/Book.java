package be.ucll.craftmanship.DDDDemo.library.catalog.books.domain;


import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.BookId;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.Isbn;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

@Entity
public class Book {
    @NotNull
    private String Publishers;

    @EmbeddedId
    private BookId id;

    @NotNull
    private String title;


    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "isbn"))
    private Isbn isbn;

    public Book(String title, Isbn isbn, String publishers) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(isbn, "isbn must not be null");
        Assert.notNull(publishers, "publishers must not be null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
        this.Publishers = publishers;
    }

    protected Book() {
        // for JPA
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public BookId getId() {
        return id;
    }

    public void setId(BookId id) {
        this.id = id;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }
}
