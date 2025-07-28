package org.griddynamics.july28;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharacter {
    public static void main(String[] args){
        String str = "anand";
        Character result = getAns(str);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Nope");
        }
    }
    static Character getAns(String str){
        Set<Character> check=new HashSet<>();
        for(char ch:str.toCharArray()){
            if(check.contains(ch)){
                return ch;
            }
            else{
                check.add(ch);
            }
        }
        return null;

    }
}
