package org.griddynamics.july16;

public class LongestPalindrome {

        public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";

            String result = "";

            for (int i = 0; i < s.length(); i++) {
                String odd = expandCenter(s, i, i);
                if (odd.length() > result.length()) result = odd;
                String even = expandCenter(s, i, i + 1);
                if (even.length() > result.length()) result = even;//odd palindromes first then even palindromes
            }

            return result;
        }

        private static String expandCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right); // corrected window
        }

        public static void main(String[] args) {
            String input = "babad";
            System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
        }
    }


