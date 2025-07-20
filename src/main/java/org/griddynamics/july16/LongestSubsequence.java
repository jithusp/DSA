package org.griddynamics.july16;

public class LongestSubsequence {
    public static int ans(String s) {
        return (int) s.chars().distinct().count();
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(ans(s));
    }
}
