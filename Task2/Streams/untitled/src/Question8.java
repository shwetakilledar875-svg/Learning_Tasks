import java.util.*;
import java.util.stream.*;

class Customer {
    boolean active;

    Customer(boolean active) {
        this.active = active;
    }

    boolean isActive() {
        return active;
    }
}

public class Question8 {
    List<Customer> customerRepo = List.of(
            new Customer(true),
            new Customer(false),
            new Customer(true)
    );

    public List<Customer> getActiveCustomers() {
        return customerRepo.stream()
                .filter(Customer::isActive)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            System.out.println("Size: " + list.size());
                            return Collections.unmodifiableList(list);
                        }
                ));
    }
}