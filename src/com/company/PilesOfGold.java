package com.company;

// https://www.codewars.com/kata/59549d482a68fe3bc2000146/train/java
// Choosing a value that's better based on the value that would be available to choose next,
// if the value available after taking the bigger immediately available value is more than the bigger value on hand the smaller value is taken,
// if the next value for both is the same, or they are next to each other the bigger value available immediately is taken.

/*This solution doesn't work, for some reason. It works plenty for the hand made tests, but random tests fail it at every pass
* I honestly don't know the reason. I've asked for an explanation in the comments of the Kata but I have received no response so this particular solution
* will remain as it is*/

public class PilesOfGold {
    int var = 0;

    public int x = 15;

    public int multiply(int var, int var2){
        System.out.println(var);
        return var * var2;
    }

    public static int[] distributionOf(int[] golds) {
//        Preparing values to serve as markers for which value gets increased
        int firstValue = 0;
        int secondValue = 0;

//        Creating a 2 element array to return, as per task requirement
        int[] answer = new int[2];

//        Creating values to point at the indexes to choose from
        int i = 0;
        int j = golds.length - 1;

//        Loop to execute the tasks
        while (j >= i) {
//            Checking if the second value has to pick
            if (secondValue < firstValue) {
//                Checking if the values between indexes i and j matter (if there's one value or they're next to each other the immediate bigger value should be chosen)
                if (j - i > 2) {
//                    If the value behind index i is bigger, choose the other value, even if value at index i is bigger (so the first index can't take the bigger value)
                    if (golds[i + 1] > golds[j - 1]) {
                        answer[1] += golds[j];
                        j--;
                    } else if (golds[i + 1] < golds[j - 1]){
                        answer[1] += golds[i];
                        i++;
                    } else {
                        if (golds[i] > golds[j]) {
                            answer[1] += golds[i];
                            i++;
                        } else {
                            answer[1] += golds[j];
                            j--;
                        }
                    }
                } else {
                    if (golds[i] > golds[j]) {
                        answer[1] += golds[i];
                        i++;
                    } else {
                        answer[1] += golds[j];
                        j--;
                    }
                }
                secondValue++;
            } else {
                if (j - i > 2) {
//                    If the value behind index i is bigger, choose the other value, even if value at index i is bigger (so the first index can't take the bigger value)
                    if (golds[i + 1] > golds[j - 1]) {
                        answer[0] += golds[j];
                        j--;
                    } else if (golds[i + 1] < golds[j - 1]){
                        answer[0] += golds[i];
                        i++;
                    } else {
                        if (golds[i] > golds[j]) {
                            answer[0] += golds[i];
                            i++;
                        } else {
                            answer[0] += golds[j];
                            j--;
                        }
                    }
                } else {
                    if (golds[i] > golds[j]) {
                        answer[0] += golds[i];
                        i++;
                    } else {
                        answer[0] += golds[j];
                        j--;
                    }
                }
                firstValue++;
            }
        }
        return answer;
    }

    public int returning(){
        var = 1;
        return var;
    }
}
