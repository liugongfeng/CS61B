package com.company;

public class BreakContinue {

    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i++){
            int sum = 0;
            if (a[i] <0 )
                continue;

            else if (a.length - i > n) {
                for (int j = i;  j <= n+i; j++) {
                    sum = sum + a[j];
                }
                a[i] = sum ;
            }

            else {
                for (int k = i; k < a.length; k++) {
                    sum = sum + a[k];
                }
                a[i] = sum;
            }

        }

    }




    public static void main(String [] args){
        int [] a = {1, 2, -3, 4, 5, 4};
        int n = 3;

        windowPosSum(a, n);
        System.out.println(java.util.Arrays.toString(a));
    }
}