package org.griddynamics;

public class UpperCaseWithASCII {
    public static void main(String[] args){
        String test="asdasdasd";
        System.out.println("Upper case converted from "+test+" to "+getAnswer(test));
    }
    public static String getAnswer(String test){
        StringBuilder ans= new StringBuilder();
        for(char ch: test.toCharArray()){
            if(ch>='a'||ch<='z'){
                ans.append((char)(ch-32));
            }
        }
        return ans.toString();
    }
}
