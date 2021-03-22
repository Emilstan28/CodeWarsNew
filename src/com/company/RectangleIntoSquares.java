package com.company;

/*https://www.codewars.com/kata/55466989aeecab5aac00003e/java
*
* You will be given two dimensions

a positive integer length
a positive integer width
You will return a collection or a string (depending on the language; Shell bash, PowerShell, Pascal and Fortran return a string) with the size of each of the squares.*/

import java.util.ArrayList;
import java.util.List;

public class RectangleIntoSquares {

    public static List<Integer> sqInRect(int lng, int wdth) {



        if (lng == wdth) {
            return null;
        }

        List<Integer> solution = new ArrayList<>();
        int shorterSide = Math.min(lng, wdth);
        int longerSide = Math.max(lng, wdth);

        while (longerSide > 0 && shorterSide > 0){
            /*Take the big rectangle, measure the minimum
            * Take the minimum, count how many times that size of square would fit and subtract
            * Take what's left, set it, repeat
            * When one of the rectangle's side is 1 take the longer side and add 1 as many times as that side length is
            *
            * Key: The smaller side always dictates the width of the square. Find a way to save the smaller side and you solve the problem
            *
            * will it always flip?
            * 3x17, 5 3x3, 3x15, leaves with 3x2, then it's 1 2x2 and 2 1x1
            * After subtracting the first square(s) the sides change, the one that was bigger is now smaller and vice versa, unless it's equally divisible but that's not an issue.
            * Solution: See above, in addition: flip the square limit to the smaller of the original, subtract what got taken away by the squaring from the longer side, repeat.*/

            int squareCount = longerSide / shorterSide;

            for (int i = squareCount; i > 0; i--) {
                solution.add(shorterSide);
            }

            int temp = longerSide;
            longerSide = shorterSide;
            shorterSide = temp - squareCount * shorterSide;


        }


        return solution;
    }
}
