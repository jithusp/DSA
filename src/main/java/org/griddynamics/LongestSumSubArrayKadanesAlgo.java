package org.griddynamics;

public class LongestSumSubArrayKadanesAlgo {

        public static int getAnswer(int[] nums) {
            int maxCurrent = nums[0];
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
                max = Math.max(max, maxCurrent);
            }

            return max;
        }

        public static void main(String[] args) {
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println("Maximum subarray sum is: " + getAnswer(nums)); // Output: 6
        }


}
