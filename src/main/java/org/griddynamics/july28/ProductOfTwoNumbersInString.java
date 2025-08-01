package org.griddynamics.july28;

public class ProductOfTwoNumbersInString {

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int mul = d1 * d2 + result[pos2];

                result[pos2] = mul % 10;
                result[pos1] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (sb.length() == 0 && r == 0) continue; // skip leading 0s
            sb.append(r);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "3";
        String s2 = "30";
        System.out.println("Product: " + multiply(s1, s2)); // Output: 5535
    }
}
