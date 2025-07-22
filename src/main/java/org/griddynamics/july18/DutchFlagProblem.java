package org.griddynamics.july18;

import java.util.Arrays;

//Dijkstra problme, use 3 pointers low, mid , high
//jst make high as len of the array and all operations with O(1), in place
public class DutchFlagProblem {
    public static void main(String[] args){
        int[] arr = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(arr)+" "+Arrays.toString(getAnswer(arr)));
    }
    static int[] getAnswer(int[] arr){
        int low=0,mid=0,high= arr.length-1;
        while (mid<=high){
            if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                mid++;low++;
            } else if (arr[mid]==1) {
                mid++;
            }
            else {
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }

        return arr;

    }
}
