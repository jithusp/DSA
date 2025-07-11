package org.griddynamics;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatedNumberInArray {
    public static void main(String[] args){
        int[] test ={2,3,4,2,3,4,1,2};
        System.out.println(getAnswer(test));
}
public static int getAnswer(int[] test){
        Map<Integer,Integer> ans=new HashMap<>();
        for(int x:test){
            if(ans.containsKey(x)){
                int count=ans.get(x);
                ans.put(x,count+1);
            }
            else{
                ans.put(x,1);
            }
        }
        int max=0,value=0;
        for (Map.Entry<Integer,Integer> answer:ans.entrySet()){
            if(max<answer.getValue()){
                max=answer.getValue();
                value=answer.getKey();
            }
        }
        return value;
    }
}
