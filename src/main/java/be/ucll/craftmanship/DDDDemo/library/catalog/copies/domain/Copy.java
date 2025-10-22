package be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.BookId;
import jakarta.persistence.*;

@Entity
public class Copy {
    @EmbeddedId
    private CopyId id;

    @Embedded
    @AttributeOverride(name = "code", column = @Column(name = "barcode"))
    private BarCode barCode;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id"))
    private BookId bookID;

    public Copy(BarCode barCode, BookId bookID) {
        this.id = new CopyId();
        this.barCode = barCode;
        this.bookID = bookID;
    }
    protected Copy() {
    }
}
