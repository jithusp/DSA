package org.griddynamics.visainterviewcoding;

public class ReverseArrayWithKBucketSize {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        getAnswer(test, k);
        for (int num : test) {
            System.out.print(num + " ");
        }
    }
    public static void getAnswer(int[] test, int k){
        int x1=0,x2=0,len= test.length;
        for(int i=0;i<len;i+=k){
            x1=i;
            x2=Math.min(i+k-1,len-1);
            while (x2>x1){
                int temp=test[x1];
                test[x1]=test[x2];
                test[x2]=temp;
                x1++;
                x2--;

            }
        }
    }
}
