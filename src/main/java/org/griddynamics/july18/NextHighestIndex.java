package org.griddynamics.july18;

import java.util.*;

public class NextHighestIndex {

    public static int[] getAns(int[] a) {
        int n = a.length;
        int[] nextGreaterIndex = new int[n];
        Arrays.fill(nextGreaterIndex, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                int prevIndex = stack.pop();
                nextGreaterIndex[prevIndex] = i;
            }
            stack.push(i);
        }
        return nextGreaterIndex;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 3, 5, 6};
        int[] nextGreaterIndex = getAns(a);
        System.out.println("Next greater index for each element:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" "+ nextGreaterIndex[i]);
        }

    }
}
