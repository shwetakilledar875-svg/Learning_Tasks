package org.stream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeData {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", 30, "IT", 60000.0));
        employees.add(new Employee(2, "Jane Smith", 25, "HR", 45000.0));
        employees.add(new Employee(3, "Alice Johnson", 28, "Finance", 55000.0));
        employees.add(new Employee(4, "Bob Brown", 35, "IT", 70000.0));
        employees.add(new Employee(5, "Samson", 32, "Finance", 48000.0));

        for(Employee emp : employees) {
            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Age: " + emp.getAge() + ", Department: " + emp.getDepartment());
        }

        //1. Find all employees whose salary is greater than 50,000
       List<Employee> salary=employees
                .stream()
                .filter(emp->emp.getSalary()>50000)
                .collect(Collectors.toList());

        System.out.println("Employees whose salary is greater than 50000: " + salary);
        System.out.println();

        //2. Find all employees who belong to the IT department
       List<Employee> it=employees
                .stream()
                .filter(emp->emp.getDepartment()=="IT")
                .collect(Collectors.toList());

        System.out.println("Employees who belong to the IT department: " +it);
        System.out.println();

        //3. Get a list of all employee names only
        List<String> names=employees
                .stream()
                .map(emp->emp.getName())
                .collect(Collectors.toList());

        System.out.println("List of all employee names: " + names);
        System.out.println();

        //4. Sort employees based on salary in increasing order
        List<Employee> increase=employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("Employees sorted based on salary in increasing order: " + increase);
        System.out.println();

        //5. Sort employees based on salary in decreasing order
        List<Employee> decrease=employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println(decrease);
        System.out.println();

        //6. Group employees by department
        Map<String, List<Employee>> groupbydept=employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Employees grouped by department: " + groupbydept);
        System.out.println();

        //7. Find the second highest salary
        double secondhighest=employees
                .stream()
                .map(emp->emp.getSalary())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(0.0);

        System.out.println("Second highest salary: " + secondhighest);
        System.out.println();

        //8. Find the employee with the maximum age
        Employee maxage=employees
                .stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);

        System.out.println("Employee with the maximum age: " + maxage);
        System.out.println();

        //9. Group employees and show only their names per department
        List<Employee> groupbydeptnames=employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName,Collectors.toList())))
                .entrySet()
                .stream()
                .map(entry->new Employee(0, String.join(", ",
                        entry.getValue()), 0, entry.getKey(), 0.0))
                .collect(Collectors.toList());

        //10. Increase salary of all employees by 10% and display
        List<Double> increasesal=employees
                .stream()
                .map(emp->emp.getSalary()*1.10)
                .collect(Collectors.toList());

        System.out.println("Increased salary of all employees by 10%: " + increasesal);

    }
}
