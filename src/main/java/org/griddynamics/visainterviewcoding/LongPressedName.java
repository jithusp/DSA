package org.griddynamics.visainterviewcoding;

public class LongPressedName {
//    String name = "alex";
//    String typed = "aaleex";
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        if(name.length()>typed.length())return false;
        while(j<typed.length()){
            if(i<name.length()&&name.charAt(i)==typed.charAt(j)){
                i++;j++;
            } else if (j>0&&typed.charAt(j)==typed.charAt(j-1)) {
                j++;
            }
            else {
                return false;
            }
        }
//        return true;
//        if(i==name.length())return true;
        return i==name.length();
    }
    public static void main(String args[]){
        LongPressedName checker = new LongPressedName();
        String name = "alex";
        String typed = "aaleex";
        boolean result = checker.isLongPressedName(name, typed);
        System.out.println("Is long pressed? " + result);  // Output: true
    }
}
