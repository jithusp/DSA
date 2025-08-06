package org.griddynamics.august1;

import java.util.*;

public class SortingListOfMapElements {
    public static void main(String[] args) {
        List<Map<String, Double>> salary = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Map<String, Double> accountMap = new HashMap<>();
            String accountNumber = "ACC" + String.format("%04d", i); // e.g., ACC0001, ACC0002
            double amt = 1000 + (random.nextDouble() * 9000); // salary between 1000 to 10000
            accountMap.put(accountNumber, amt);
            salary.add(accountMap);
        }
        for (Map<String, Double> account : salary) {
            for (Map.Entry<String, Double> entry : account.entrySet()) {
                System.out.println("Account: " + entry.getKey() + ", Balance: " + entry.getValue());
            }
        }
        salary.sort((map1, map2) -> {
            Double balance1 = map1.values().iterator().next();
            Double balance2 = map2.values().iterator().next();
            return balance1.compareTo(balance2); // reverse order
        });
        for (Map<String, Double> account : salary) {
            for (Map.Entry<String, Double> entry : account.entrySet()) {
                System.out.println("////////////////After Sort fucntion////////////////////");
                System.out.println("Account: " + entry.getKey() + ", Balance: " + entry.getValue());
            }
        }


    }
}
