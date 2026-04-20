import java.util.*;
import java.util.stream.*;

record ConfigLine(String key, String value) {}

public class Question6 {
    public static void main(String[] args) {
        List<ConfigLine> lines = List.of(
                new ConfigLine("server", "prod01"),
                new ConfigLine("timeout", "30"),
                new ConfigLine("server", "backup-prod-ny-01"),
                new ConfigLine("timeout", "60")
        );

        Map<String, String> result = lines.stream()
                .collect(Collectors.toMap(
                        ConfigLine::key,
                        ConfigLine::value,
                        (v1, v2) -> v2.length() > v1.length() ? v2 : v1
                ));

        System.out.println(result);
    }
}