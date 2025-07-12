package org.griddynamics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args){
        int[] stones = {2, 7, 4, 1, 8, 1};
        int result = lastStoneWeight(stones);
        System.out.println("Last stone weight: " + result);  // Output:
    }
    static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> des=new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones){
            des.add(stone);
        }
        while(des.size()>1){
            int x=des.poll();
            int y=des.poll();
            if(x!=y){
                des.add((x-y));
            }
        }
//        return des.poll();
        return des.isEmpty()?0:des.poll();
    }
}
// priority queue with reverseorder comparator so that we can have the heaviest element as head instead of how minHeap works
//minHeap uses a binary tree so that the node at head is smallest from its children
