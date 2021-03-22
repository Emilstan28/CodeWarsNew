package com.company;

// https://www.codewars.com/kata/5ce399e0047a45001c853c2b
// The target is to create a decreasing array of results of summing the elements of the original array

import java.util.Arrays;

public class SumOfParts {

    public static int[] sumParts(int[] ls) {

//         Putting the array into a stream to sum up all the numbers
        int sumOfAll = Arrays.stream(ls).sum();

//         Creating an array to hold the numbers (the +1 is to accommodate for the final 0 when all the elements are subtracted)
        int[] sums = new int[ls.length + 1];

//         Putting the numbers in their places, making it safe from going out of bounds with the original array
        for (int i = 0; i < sums.length; i++) {
            sums[i] = sumOfAll;
            if (i < ls.length) {
                sumOfAll -= ls[i];
            }
        }

//         Returning the resulting array
        return sums;
    }
}
