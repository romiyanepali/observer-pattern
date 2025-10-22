package be.ucll.craftmanship.DDDDemo.library.catalog.books.infrastructure;

import java.util.List;

public record OpenLibrarySearchResult(List<String> publishers,
                                      String title,
                                      List<String> isbn_13,
                                      int revisions) {
}
