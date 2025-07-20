package org.griddynamics.july16;

import java.util.*;

public class LongestSubstring {
    public static int getAns(String s) {
        Set<Character> ans = new HashSet<>();
        int left = 0, max = 0;
//inside the while loop, if a repeating char is found , then the ans set is reset, so left becomes the counter
        //of the longest substring.
        for (int right = 0; right < s.length(); right++) {
            while (ans.contains(s.charAt(right))) {
                ans.remove(s.charAt(left));
                left++;
            }
            ans.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(getAns(s)); // Output: 3 ("abc")
    }
}
