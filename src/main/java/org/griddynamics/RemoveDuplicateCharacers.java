package org.griddynamics;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicateCharacers {
    public static void main(String[] args) {
        String input = "applemangotang";
        String output = removeDuplicates(input);
        System.out.println("Original string: " + input);
        System.out.println("After removing duplicates: " + output);
    }
    static String removeDuplicates(String input){
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        StringBuilder ans=new StringBuilder();
        for(char ch:input.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
