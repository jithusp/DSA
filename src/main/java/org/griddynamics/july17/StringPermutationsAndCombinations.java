package org.griddynamics.july17;

public class StringPermutationsAndCombinations {
    public static void permute(String str, String result) {
        if (str.length() == 0) {
            System.out.println("Permutation: " + result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permute(remaining, result + ch);
        }
    }
    public static void combine(String str, int start, String result) {
        if (!result.isEmpty()) {
            System.out.println("Combination: " + result);
        }

        for (int i = start; i < str.length(); i++) {
            combine(str, i + 1, result + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String input = "ABC";

        System.out.println("All Permutations of " + input + ":");
        permute(input, "");

        System.out.println("All Combinations of " + input + ":");
        combine(input, 0, "");
    }
}
