package org.griddynamics.august1;

import java.util.Stack;

public class MaxStackImplementation {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }
    public int pop() {
        int removed = stack.pop();
        if (removed == maxStack.peek()) {
            maxStack.pop();
        }
        return removed;
    }
    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }


    public static void main(String[] args){
        MaxStackImplementation ms = new MaxStackImplementation();
        ms.push(5);
        ms.push(1);
        ms.push(10);
        System.out.println(ms.getMax()); // 10
        ms.pop();                        // removes 10
        System.out.println(ms.getMax()); // 5
    }
}
