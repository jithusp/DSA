package org.griddynamics;

import java.util.*;

public class GroupAnagrams {
    //String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    public List<List<String>> groupAnagrams(String[] input) {
        Map<String,List<String>> ans= new HashMap<>();
        for(String word:input){
            char[] wordChar= word.toCharArray();
            Arrays.sort(wordChar);
            String converted=new String(wordChar);
            if(!ans.containsKey(converted)){
                ans.put(converted,new ArrayList<>());
            }
            ans.get(converted).add(word);

        }
//        return null;
        return new ArrayList<>(ans.values());
    }
}
