import java.util.*;
import java.util.stream.*;

record Order(int id, double amount, boolean isPrime) {}

public class Question10 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, 49.99, false),
                new Order(2, 120.00, true),
                new Order(3, 15.50, true),
                new Order(4, 89.99, false)
        );

        Map<Boolean, Double> revenue = orders.stream()
                .collect(Collectors.partitioningBy(
                        Order::isPrime,
                        Collectors.summingDouble(Order::amount)
                ));

        System.out.println(revenue);
    }
}