import java.util.*;
import java.util.stream.*;

record Student(String name, int grade, double attendance) {}

public class Question2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alex", 95, 98.5),
                new Student("Blake", 95, 92.0),
                new Student("Casey", 88, 99.0),
                new Student("Drew", 95, 95.0),
                new Student("Ellis", 91, 80.0)
        );

        List<String> top3 = students.stream()
                .sorted(Comparator.comparing(Student::grade).reversed()
                        .thenComparing(Comparator.comparing(Student::attendance).reversed()))
                .limit(3)
                .map(Student::name)
                .toList();

        System.out.println(top3);
    }
}