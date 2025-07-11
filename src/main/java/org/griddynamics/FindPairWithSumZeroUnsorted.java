package org.griddynamics;

import java.util.HashSet;
import java.util.Set;

public class FindPairWithSumZeroUnsorted {
    public static void main(String[] args) {
        int[] test = {3, -2, 1, 4, -3, 5};
        getAnswer(test); // Output: Pair found: -3 & 3
    }
    static void getAnswer(int[] test){
        Set<Integer> ans=new HashSet<>();
        for(int x:test){
            if(ans.contains(x*(-1))){
                System.out.println("Pair : "+ x+", "+(-x));

            }
            else{
                ans.add(x);
            }

        }
    }
}
