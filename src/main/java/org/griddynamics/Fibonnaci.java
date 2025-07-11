package org.griddynamics;

import java.util.List;

public class Fibonnaci {
    public static void main(String[] args){
        int n=10;
        getAnswer(n);
    }
    public static void getAnswer(int n){
        int a=0,b=1;
        for(int i=0;i<n;i++){
            System.out.print(a+" , ");
            int x=a+b;
            a=b;
            b=x;//the carryover sum is b so..

        }
    }
}
