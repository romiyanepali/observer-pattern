package be.ucll.craftmanship.DDDDemo.library.catalog.books.infrastructure;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.Book;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.BookId;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.Isbn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, BookId> {
    Book findBookByIsbn(Isbn isbn);
    void deleteBookById(BookId id);
    List<Book> findByTitleContainingAndPublishersContaining(String title, String publisher);
    List<Book> findByTitleContaining(String title);
    List<Book> findByPublishersContaining(String publisher);
}
