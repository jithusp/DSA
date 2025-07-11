package org.griddynamics;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacterInString {
    public static void main(String args[]){
        String test="hhhhelllooo";
        System.out.println("The first non repeating character is:"+ getAnswer(test));
    }
    public static Character getAnswer(String test){
        Map<Character, Integer> ans= new LinkedHashMap<>();
        for(char c: test.toCharArray()){
            if(ans.containsKey(c)){
               int count=ans.get(c);
               ans.put(c,count+1);
            }
            else{
                ans.put(c,1);
            }
        }
        for(Map.Entry<Character, Integer> firstLetter: ans.entrySet() ){
            if(firstLetter.getValue()==1){
                return firstLetter.getKey();
            }
        }
        return null;
    }
}
