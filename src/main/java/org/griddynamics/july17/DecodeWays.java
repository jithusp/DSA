package org.griddynamics.july17;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int prev = 1;
        int prev2 = 1;

        for (int i = 1; i < s.length(); i++) {
            int curr = 0;

            if (s.charAt(i) != '0') {
                curr += prev;
            }

            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226")); // Output: 3
    }
}
