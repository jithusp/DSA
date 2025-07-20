package org.griddynamics.july16;
import java.math.BigInteger;
public class ValidParenthesisUsingCatalan {

        public static BigInteger countValidParenthesisOrders(int x) {
            return factorial(2 * x)
                    .divide(factorial(x).multiply(factorial(x + 1)));
        }

        private static BigInteger factorial(int num) {
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= num; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }

        public static void main(String[] args) {
            int x = 4;
            System.out.println("Number of valid parenthesis orders for " + x + " pairs: " + countValidParenthesisOrders(x));
        }
    }


