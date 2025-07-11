package org.griddynamics;

public class ReversedString {
    public static void main(String args[]) {
        String input = "My Name is John Honai. I am a don ";
        System.out.println("The reversed string is : " + getItReversed(input));
    }

    public static String getItReversed(String input) {
        String[] splitInput = input.split("\\.");
        String[] eachWord = splitInput[0].trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int j = 0; j <splitInput.length; j++) {
            for (int i = eachWord.length - 1; i >= 0; i--) {
                result.append(eachWord[i]);
                result.append(" ");
            }

            if (splitInput.length - 1 != j) result.append(".");
        }
        return result.toString();
    }
    /// /use stack and check it out
}
