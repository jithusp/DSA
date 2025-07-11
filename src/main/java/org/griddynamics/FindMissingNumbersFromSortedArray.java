package org.griddynamics;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbersFromSortedArray {
    public static void main(String[] args) {
        int[] test = {1, 2, 4, 5, 7};
        List<Integer> missing = getAnswer(test);
        System.out.println("Missing numbers: " + missing);
    }

    public static List<Integer> getAnswer(int[] test) {
        List<Integer> ans = new ArrayList<>();
        int x=test[0],y=x;
        for (int i = 0; i < test.length; i++) {
            if (y < test[i]) {
                ans.add(y);
                y++;
                i--;
            } else if (y == test[i]) {
                y++;
            }
        }
        return ans;
    }
}
