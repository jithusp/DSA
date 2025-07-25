package org.griddynamics.visainterviewcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
//    int[] nums = {-1, 0, 1, 2, -1, -4}; targ;et =0
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
//            if(nums[i]>0)break;
            if(i>0&&nums[i]==nums[i-1])continue;
            int left=i+1, right = nums.length-1;
            while( left<right){
                int sum= nums[i]+nums[left]+nums[right];
                if(sum==0) {
                    answer.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1])left++;
                    while(left<right && nums[right]==nums[right-1])right--;
                    left++;
                    right--;

                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }

            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        ThreeSum Problem from leetcode:
        ThreeSum solver = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solver.threeSum(nums);

        System.out.println("Triplets that sum to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

