package com.company;

/*https://www.codewars.com/kata/5868b2de442e3fb2bb000119/java

Let us call weight of a number the sum of its digits. For example 99 will have "weight" 18, 100 will have "weight" 1.

Two numbers are "close" if the difference of their weights is small.

Task:
For each number in strng calculate its "weight" and then find two numbers of strng that have:

the smallest difference of weights ie that are the closest
with the smallest weights
and with the smallest indices (or ranks, numbered from 0) in strng
Output:
an array of two arrays, each subarray in the following format:
[number-weight, index in strng of the corresponding number, original corresponding number in strng]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ClosestAndSmallest {
    public static int[][] closest(String strng) {
        System.out.println(strng);
        HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> indexes = new HashMap<>();

        if (strng.isEmpty()){
            return new int[0][0];
        }

        String[] individualNumbers = strng.split(Pattern.quote(" "));
        int[] paramsSummed = new int[individualNumbers.length];

        for (int i = 0; i < individualNumbers.length; i++) {
            int sumOfDigits = String.valueOf(individualNumbers[i]).chars().map(Character::getNumericValue).sum();
            if (!values.containsKey(sumOfDigits)) {
                values.put(sumOfDigits, new ArrayList<>());
            }
            values.get(sumOfDigits).add(Integer.parseInt(individualNumbers[i]));

            if (!indexes.containsKey(Integer.parseInt(individualNumbers[i]))) {
                indexes.put(Integer.parseInt(individualNumbers[i]), new ArrayList<>());
            }
            indexes.get(Integer.parseInt(individualNumbers[i])).add(i);
            paramsSummed[i] = sumOfDigits;
        }

        paramsSummed = Arrays.stream(paramsSummed).sorted().toArray();
        int leastDifferenceInWeight = paramsSummed[0] - paramsSummed[1];
        if (leastDifferenceInWeight < 0){
            leastDifferenceInWeight *= -1;
        }
        int firstOfTheTwo = paramsSummed[0];
        int secondOfTheTwo = paramsSummed[1];

        for (int i = 1; i < paramsSummed.length - 1; i++) {
            if (paramsSummed[i] - paramsSummed[i + 1] < 0) {
                if ((paramsSummed[i] - paramsSummed[i + 1]) * -1 < leastDifferenceInWeight) {
                    leastDifferenceInWeight = (paramsSummed[i] - paramsSummed[i + 1]) * -1;
                    firstOfTheTwo = paramsSummed[i];
                    secondOfTheTwo = paramsSummed[i + 1];
                }
            } else if (paramsSummed[i] - paramsSummed[i + 1] < leastDifferenceInWeight) {
                leastDifferenceInWeight = paramsSummed[i] - paramsSummed[i + 1];
                firstOfTheTwo = paramsSummed[i];
                secondOfTheTwo = paramsSummed[i + 1];
            }
        }

        if (firstOfTheTwo == secondOfTheTwo && values.get(firstOfTheTwo).get(0).equals(values.get(firstOfTheTwo).get(1))) {
            return new int[][]{{firstOfTheTwo, indexes.get(values.get(firstOfTheTwo).get(0)).get(0), values.get(firstOfTheTwo).get(0)}, {secondOfTheTwo, indexes.get(values.get(firstOfTheTwo).get(1)).get(1), values.get(secondOfTheTwo).get(1)}};
        } else if (firstOfTheTwo == secondOfTheTwo) {
            return new int[][]{{firstOfTheTwo, indexes.get(values.get(firstOfTheTwo).get(0)).get(0), values.get(firstOfTheTwo).get(0)}, {secondOfTheTwo, indexes.get(values.get(firstOfTheTwo).get(1)).get(0), values.get(secondOfTheTwo).get(1)}};
        } else {
            return new int[][]{{firstOfTheTwo, indexes.get(values.get(firstOfTheTwo).get(0)).get(0), values.get(firstOfTheTwo).get(0)}, {secondOfTheTwo, indexes.get(values.get(secondOfTheTwo).get(0)).get(0), values.get(secondOfTheTwo).get(0)}};
        }

    }
}
