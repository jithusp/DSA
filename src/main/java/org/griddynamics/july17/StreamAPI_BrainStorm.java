package org.griddynamics.july17;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI_BrainStorm {

    public static void main(String[] args) {
 //1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> even = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> odd = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println("Even: " + even + ", Odd: " + odd);

//2
        List<String> stringList = Arrays.asList("abc-def", "ghi", "jkl-mno");
        stringList.stream()
                .map(s -> s.contains("-") ? s.toUpperCase() : s)
                .forEach(System.out::println);
//3
        int[] arr = {1, 2, 3, 4, 5};
        int totalProduct = Arrays.stream(arr).reduce(1, (a, b) -> a * b);
        int[] result = Arrays.stream(arr).map(n -> totalProduct / n).toArray();
        System.out.println("Product Except Self: " + Arrays.toString(result));

//4
        List<Integer> collectiontoList = numbers.stream().filter(n -> n > 2).collect(Collectors.toList());
        System.out.println("collectiontolist: " + collectiontoList);
        List<Integer>tolistnormal=numbers.stream().filter(n->n>=1).toList();
        System.out.println("tolistnormal: " + tolistnormal);
// 5
        Optional<Integer> last = numbers.stream().reduce((first, second) -> second);
        System.out.println("Last: " + last.orElse(null));

// 6.
        List<String> list1 = Arrays.asList("one", "one", "two", "two", "three", "four");
        Map<String, Long> frequencyUsingGrouping = list1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency Map using groupingBy: " + frequencyUsingGrouping);

// 6
        Map<String, Long> frequencyUsingToMap = list1.stream()
                .collect(Collectors.toMap(Function.identity(), val -> 1L, Long::sum));
        System.out.println("Frequency Map using toMap: " + frequencyUsingToMap);

        // 7 unique fruits
        List<String> listOfFruits = Arrays.asList("apple", "banana", "orange", "apple", "grape", "banana", "kiwi", "orange");
        List<String> uniqueFruits = listOfFruits.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique Fruits: " + uniqueFruits);

        // 8
        List<Integer> intList = Arrays.asList(10, 20, 30, 40);
        int sum = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
        // 9
        Optional<Integer> max = intList.stream().max(Integer::compare);
        System.out.println("Max: " + max);
        // 10
        Optional<Integer> min = intList.stream().min(Integer::compare);
        System.out.println("Min: " + min);

        // 11
        long countA = listOfFruits.stream().filter(s -> s.startsWith("a")).count();
        System.out.println("Starts with a: " + countA);
    }
}
