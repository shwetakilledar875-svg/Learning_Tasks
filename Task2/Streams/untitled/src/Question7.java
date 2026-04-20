import java.util.*;

record Book(String title, List<String> authors) {}
record Shelf(List<Book> books) {}
record Library(List<Shelf> shelves) {}

public class Question7 {
    public static void main(String[] args) {
        Library library = new Library(List.of(
                new Shelf(List.of(
                        new Book("Java", List.of("Alice", "Bob")),
                        new Book("Spring", List.of("Alice"))
                )),
                new Shelf(List.of(
                        new Book("Docker", List.of("Charlie"))
                ))
        ));

        List<String> authors = library.shelves().stream()
                .flatMap(shelf -> shelf.books().stream())
                .flatMap(book -> book.authors().stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println(authors);
    }
}