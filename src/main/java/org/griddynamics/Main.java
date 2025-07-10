package org.griddynamics;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ThreeSum Problem from leetcode:
//        ThreeSum solver = new ThreeSum();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> result = solver.threeSum(nums);
//
//        System.out.println("Triplets that sum to zero:");
//        for (List<Integer> triplet : result) {
//            System.out.println(triplet);
//        }

//        Longpressed name from leetcode::: below
//        LongPressedName checker = new LongPressedName();
//        String name = "alex";
//        String typed = "aaleex";
//        boolean result = checker.isLongPressedName(name, typed);
//        System.out.println("Is long pressed? " + result);  // Output: true

        //group anagrams
        GroupAnagrams solver = new GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> grouped = solver.groupAnagrams(input);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }
}