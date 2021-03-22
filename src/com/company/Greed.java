package com.company;

// https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java

/*Count the "dice rolls" given in the input array according to the following:
*  Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point
 *
 * Tests passed, solution correct*/

public class Greed {
    public static int greedy(int[] dice){
        int answer = 0;

        int[] values = new int[6];
        for (int number : dice){
            values[number - 1]++;
        }

        for (int x = 0; x < values.length; x++){
            switch (x){
                case 0:
                    answer += ( (values[x] / 3) * 1000) + ( (values[x] % 3) * 100);
                    break;
                case 1:
                    answer += ( (values[x] / 3) * 200);
                    break;
                case 2:
                    answer += ( (values[x] / 3) * 300);
                    break;
                case 3:
                    answer += ( (values[x] / 3) * 400);
                    break;
                case 4:
                    answer += ( (values[x] / 3) * 500) + ( (values[x] % 3) * 50);
                    break;
                case 5:
                    answer += ( (values[x] / 3) * 600);
                    break;
            }
        }

        return answer;
    }
}
