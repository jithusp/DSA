package org.griddynamics.visainterviewcoding;

import java.util.*;

public class ListOfIntegersRemoveDuplicatesMaintainOrder {
    public static void main(String[] args){
        List<Integer> test= Arrays.asList(4, 5, 4, 2, 2, 3, 1, 5);
        System.out.println("Before"+test);
        System.out.println("After"+getAnswer(test));

    }
    static List<Integer> getAnswer(List<Integer> test){
        Set<Integer>ans=new LinkedHashSet<>();
        ans.addAll(test);
        return new ArrayList<>(ans);
    }
}
