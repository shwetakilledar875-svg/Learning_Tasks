import java.util.*;
import java.util.stream.*;

class Transaction {
    int id;
    String city;
    String category;
    double amount;

    Transaction(int id, String city, String category, double amount) {
        this.id = id;
        this.city = city;
        this.category = category;
        this.amount = amount;
    }

    int getId() { return id; }
    String getCity() { return city; }
    String getCategory() { return category; }
}

public class Question5 {
    public static void main(String[] args) {
        List<Transaction> txns = List.of(
                new Transaction(101, "NYC", "Food", 15.0),
                new Transaction(102, "LA", "Tech", 200.0),
                new Transaction(103, "NYC", "Tech", 50.0),
                new Transaction(104, "NYC", "Food", 30.0)
        );

        Map<String, Map<String, List<Integer>>> result = txns.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCity,
                        Collectors.groupingBy(
                                Transaction::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.mapping(Transaction::getId, Collectors.toList()),
                                        list -> {
                                            list.sort(Integer::compareTo);
                                            return Collections.unmodifiableList(list);
                                        }
                                )
                        )
                ));

        System.out.println(result);
    }
}