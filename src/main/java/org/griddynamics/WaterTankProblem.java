package org.griddynamics;

public class WaterTankProblem {
    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int target = 49;
        System.out.println(getAnswer(test));
    }

    static int getAnswer(int[] test) {
        int left = 0, right = test.length-1, vol = 0,maxVol=0;
        while (left < right) {
            int width = right-left;
            vol = (Math.min(test[left], test[right])) * width;
            maxVol=Math.max(vol,maxVol);
            if (test[left] < test[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxVol;
    }
}
