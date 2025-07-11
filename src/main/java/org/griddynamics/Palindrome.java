package org.griddynamics;

public class Palindrome {
    public static void main(String[] args){
        String test="racecar";
        System.out.println("Is palindrome? " + isPalindrome(test));  // Output: true

    }
    public static boolean isPalindrome(String test){
        boolean check=false;
        int mid=(test.length()-1)/2;
        for(int i=0;i<mid;i++){
            if(test.charAt(i)==test.charAt(test.length()-i-1)){
                check=true;
            }
            else{return false;}
        }
        return true;
    }
}
