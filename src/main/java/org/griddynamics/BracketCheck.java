package org.griddynamics;

import java.util.Stack;

public class BracketCheck {
    public static void main(String[] args) {
        String input1 = "{()sh}})";
        String input2 = "{[()()]}";

        System.out.println("Input 1 valid? " + getAnswer(input1)); // false
        System.out.println("Input 2 valid? " + getAnswer(input2)); // true
    }

    static boolean getAnswer(String input) {
        Stack<Character> test = new Stack<>();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    test.push(ch);
                    break;
                case ')':
                    if (test.isEmpty() || test.pop() != '(') return false;
                    break;
                case '}':
                    if (test.isEmpty() || test.pop() != '{') return false;
                    break;
                case ']':
                    if (test.isEmpty() || test.pop() != '[') return false;
                    break;

            }

        }
        return test.isEmpty();
    }
}
