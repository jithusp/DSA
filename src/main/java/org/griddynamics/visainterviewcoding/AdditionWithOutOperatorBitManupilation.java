package org.griddynamics.visainterviewcoding;

public class AdditionWithOutOperatorBitManupilation {
    public static void main(String args[]){
        int x=10;
        int y=12;
        System.out.println("Sum :: "+getAnswer(x,y));
    }
    public static int getAnswer(int x, int y){
        while(y!=0){
            int carry=x&y;
            x=x^y;
            y=carry<<1;
        }
        return x;
    }
}
