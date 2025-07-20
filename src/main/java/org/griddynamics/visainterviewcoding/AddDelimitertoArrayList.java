package org.griddynamics.visainterviewcoding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddDelimitertoArrayList {
    public static void main(String[] args){
        List<Integer> test=new ArrayList<>();
        for(int i=0;i<=100;i++){
            test.add(i);
        }
//        StringBuilder ans= new StringBuilder();
//        for(int i=0;i<=100;i++){
//            ans.append(test.get(i));
//            if(i<test.size()-1){
//                ans.append(",");
//            }
//        }
//        System.out.println(ans.substring(0,10));
        String testAnswer= test.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
