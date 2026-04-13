package org.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Day2Streams {

    public static void main(String[] args) {
        //1. Given a list of integers, return a list where each number is doubled.
      List<Integer> number= Arrays.asList(1,2,3,4,5);
      List<Integer> doublenum=number
              .stream()
              .map(n->n*2)
              .collect(Collectors.toList());

        System.out.println("List where each number is doubled: " + doublenum);
        System.out.println();

        //2. Given a list of strings, return a list where each string is converted to uppercase.
        List<String> words=Arrays.asList("hello","world","java","stream");
        List<String> uppercase=words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("List of words in uppercase: " + uppercase);
        System.out.println();

        //3.Get Length of Each String
        List<Integer> length=words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Length of each string: " + length);
        System.out.println();

        //4. From a list of strings, return first character of each.
        List<Character> extract=words.stream().map(s->s.charAt(0))
                .collect(Collectors.toList());

        System.out.println("First character of each string: " + extract);
        System.out.println();

        //5.Convert numeric strings to integers.
        List<String> numeric=Arrays.asList("1","2","3","4","5");
        List<Integer> convert=numeric.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

      System.out.println("Numeric strings converted to integers: " + convert);
      System.out.println();

      //6.Add "@gmail.com" to usernames.
      List<String> suffix=words.stream()
              .map(s->s+"@gmail.com")
              .collect(Collectors.toList());

      System.out.println("Usernames with '@gmail.com' added: " + suffix);
      System.out.println();

      //7.Convert nested list into a single list.
        List<List<Integer>> nested=Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> flatten=nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

      System.out.println("Nested list flattened into a single list: " + flatten);
      System.out.println();

      //8. Add 10, then square the result.
      List<Integer> square=number.stream()
              .map(n->(n+10)*(n+10))
              .collect(Collectors.toList());

      System.out.println("List after adding 10 and squaring the result: " + square);
      System.out.println();

      //9. Find First Element Greater Than 10
      List<Integer> list = Arrays.asList(5, 8, 12, 20);
      int greater=list.stream()
              .filter(n->n>10).findFirst().orElse(0);

      System.out.println("First element greater than 10: " + greater);
      System.out.println();

      //10. Count Frequency of Each Element
      List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 3, 3);
     Map<Integer, Long> frequency=list1.stream()
              .collect(Collectors.groupingBy(n->n, Collectors.counting()));

      System.out.println("Frequency of each element: " + frequency);
      System.out.println();
    }
}
