package org.griddynamics;

import java.util.Arrays;

public class SortZerosAndOnes {
    public static void main(String[] args) {
        int[] test = {1, 1, 1, 0, 1, 0};
        getAnswer(test);
        System.out.println("Sorted Array: " + Arrays.toString(test));
    }
    static void getAnswer(int[] test) {
        int left=0,right= test.length-1;
        while(left<right){
            while(left<right&&test[left]==0){
                left++;
            }
            while(left<right&&test[right]==1) {
                right--;
            }
            if(left<right){
                int temp=test[left];
                test[left]=test[right];
                test[right]=temp;
                left++;
                right--;
            }
        }
    }
}
