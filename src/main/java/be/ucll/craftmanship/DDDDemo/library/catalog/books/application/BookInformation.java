package be.ucll.craftmanship.DDDDemo.library.catalog.books.application;

import java.util.List;

public record BookInformation(String title, List<String> publishers) {
}
