import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Question9 {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. The fox is quick and the dog is lazy.";

        Map<String, Long> top3 = Pattern.compile("\\W+")
                .splitAsStream(text.toLowerCase())
                .filter(word -> word.length() >= 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.println(top3);
    }
}