package org.griddynamics.visainterviewcoding;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
    public static void main(String[] args){
        int[] a={1,5,9};
        int[] b={2,3,8};
        System.out.println("Merged Array :"+getAnswer(a,b));
    }
    public static List<Integer> getAnswer(int[]a, int[]b){
        int i=0,j=0;
        List<Integer> ans=new ArrayList<>();
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                ans.add(a[i]);
                i++;
            }
            else{
                ans.add(b[j]);
                j++;
            }
        }
        while(i<a.length){
            ans.add(a[i]);
            i++;
        }
        while(j<b.length){
            ans.add(b[j]);
            j++;
        }
        return ans;

    }
}
