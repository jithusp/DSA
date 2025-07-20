package org.griddynamics.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    static class Transaction{
        String date;
        int amount;

        public Transaction(String date, int amount) {
            this.date = date;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer>ans= Stream.concat(list1.stream(),list2.stream())
                .sorted()
                .collect(Collectors.toList());
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer>ans2=transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getDate,Collectors.summingInt(Transaction::getAmount)));
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        OptionalInt ans3= Arrays.stream(array).sorted().skip(k-1).findFirst();
        System.out.println(ans3);
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> freq=words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean,List<Integer>>ans5=numbers.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));

    }
}
