package org.griddynamics;

import java.util.HashMap;
import java.util.Map;

public class CountOfRepeatedFruits {
    public static void main(String args []){
        String input="Apple,Banana,Apple,Cherry,Banana,Apple,Cherry";
        getAnswer(input);
    }
    public static void getAnswer(String input){
        String[] fruit=input.split(",");
        Map<String,Integer> freq=new HashMap<>();
        for(String eachWord: fruit){
            if(freq.containsKey(eachWord)){
                int count=freq.get(eachWord);
                freq.put(eachWord,count+1);
            }
            else{
                freq.put(eachWord,1);
            }
        }
        for(Map.Entry<String, Integer> freqMapofEachWord: freq.entrySet()){
            System.out.println(freqMapofEachWord.getKey()+" : "+ freqMapofEachWord.getValue());
        }
    }
}
