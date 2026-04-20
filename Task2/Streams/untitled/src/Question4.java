import java.util.*;

record Item(String name, int qty, double price) {}

public class Question4 {
    public static void main(String[] args) {
        List<Item> cart = List.of(
                new Item("Laptop", 1, 1200.00),
                new Item("Mouse", 2, 25.50),
                new Item("Keyboard", 1, 85.00)
        );

        double total = cart.stream()
                .map(item -> item.qty() * item.price())
                .reduce(0.0, Double::sum) * 0.9;

        System.out.println(total);
    }
}