package org.griddynamics;

public class FindMissingAndRepeating {
    public static void findNumbers(int[] arr) {
        int n = arr.length;

        long S = (long) n * (n + 1) / 2;
        long Sq = (long) n * (n + 1) * (2 * n + 1) / 6;
        long S_actual = 0, Sq_actual = 0;
        for (int num : arr) {
            S_actual += num;
            Sq_actual += (long) num * num;
        }
        long diff = S - S_actual;
        long squareDiff = Sq - Sq_actual;
        long sum = squareDiff / diff;
        long missing = (diff + sum) / 2;
        long repeating = missing - diff;
        System.out.println("Missing = " + missing + ", Repeating = " + repeating);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        findNumbers(arr);
    }
}
