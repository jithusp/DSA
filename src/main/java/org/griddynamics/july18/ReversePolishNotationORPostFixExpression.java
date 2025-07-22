package org.griddynamics.july18;

import javax.management.ObjectName;
import java.util.*;

public class ReversePolishNotationORPostFixExpression {
    public static void main(String[] args) {
        List<Object> exp = List.of(5, 3, "+");
        System.out.println("Result: " + getAnswer(exp)); // Output: 8
    }
    static int getAnswer(List<Object> exp){
        Deque<Integer> stack=new ArrayDeque<>();
        for(Object obj:exp){
            if(obj instanceof Integer){
                stack.push(((Integer) obj).intValue());

            }
            else if(obj instanceof String) {
                int x=stack.pop();
                int y=stack.pop();
                switch ((String)obj){
                    case "+":stack.push(x+y);break;
                    case "-":stack.push(x-y);break;
                    case "*":stack.push(x*y);break;
                    default:stack.push(0);break;
                }

            }
        }
        return stack.pop();
    }
}
