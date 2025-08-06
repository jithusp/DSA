package org.griddynamics.august1;

import java.util.*;

public class AllRepeatingChars {
    public static List<Character> getRepeatingChars(String str) {
        Set<Character> seen = new HashSet<>();
        Set<Character> added = new HashSet<>();
        List<Character> repeating = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            if (seen.contains(ch)) {
                if (!added.contains(ch)) {
                    repeating.add(ch);
                    added.add(ch);
                }
            } else {
                seen.add(ch);
            }
        }

        return repeating;
    }

    public static void main(String[] args) {
        String input = "qwerrtyut";
        List<Character> result = getRepeatingChars(input);
        System.out.println("Repeating characters: " + result);  // Output: [r, t]
    }
}
