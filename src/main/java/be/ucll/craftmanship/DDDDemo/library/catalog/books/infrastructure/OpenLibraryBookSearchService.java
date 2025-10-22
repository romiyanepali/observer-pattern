package be.ucll.craftmanship.DDDDemo.library.catalog.books.infrastructure;

import be.ucll.craftmanship.DDDDemo.library.catalog.books.application.BookInformation;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.application.BookSearchService;
import be.ucll.craftmanship.DDDDemo.library.catalog.books.domain.valueObjects.Isbn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OpenLibraryBookSearchService implements BookSearchService {
    private final RestClient restClient;

    public OpenLibraryBookSearchService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://openlibrary.org")
                .build();
    }

    @Override
    public BookInformation search(Isbn isbn) {
        OpenLibrarySearchResult result =
                restClient
                        .get()
                        .uri("isbn/{isbn}.json", isbn.value())
                        .retrieve()
                        .body(OpenLibrarySearchResult.class);
        return new BookInformation(result.title(), result.publishers());
    }
}
