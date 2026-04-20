import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class Q1 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(2, "Bob", "Engineering", 65000),
                new Employee(3, "Charlie", "HR", 72000),
                new Employee(4, "Diana", "HR", 58000),
                new Employee(5, "Eve", "Engineering", 95000),
                new Employee(6, "Frank", "Marketing", 45000)
        );

        Map<Boolean, Map<String, Long>> result =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() >= 70000,
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.counting()
                                )
                        ));

        System.out.println(result);
    }
}