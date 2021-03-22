package com.company;

public class SquareSum {
    public static int squareSum(int[] n) {
        int sum = 0;
        for (int number : n){
            sum += Math.pow(number, 2);
        }
        return sum;
    }
}
