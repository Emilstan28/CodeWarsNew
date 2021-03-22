package com.company;

// https://www.codewars.com/kata/55b3425df71c1201a800009c/java

/*You are the "computer expert" of a local Athletic Association (C.A.A.). Many teams of runners come to compete.
Each time you get a string of all race results of every team who has run.
For example here is a string showing the individual results of a team of 5 runners:

"01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"

Each part of the string is of the form: h|m|s where h, m, s (h for hour, m for minutes, s for seconds) are positive or null integer
(represented as strings) with one or two digits. There are no traps in this format.

To compare the results of the teams you are asked for giving three statistics; range, average and median.

Range : difference between the lowest and highest values. In {4, 6, 9, 3, 7} the lowest value is 3, and the highest is 9, so the range is 9 − 3 = 6.

Mean or Average : To calculate mean, add together all of the numbers in a set and then divide the sum by the total count of numbers.

Median : In statistics, the median is the number separating the higher half of a data sample from the lower half.
The median of a finite list of numbers can be found by arranging all the observations from lowest value to highest value and picking the middle one
(e.g., the median of {3, 3, 5, 9, 11} is 5) when there is an odd number of observations. If there is an even number of observations,
then there is no single middle value; the median is then defined to be the mean of the two middle values
(the median of {3, 5, 6, 9} is (5 + 6) / 2 = 5.5).

Your task is to return a string giving these 3 values. For the example given above, the string result will be

"Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"

of the form: "Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"`

where hh, mm, ss are integers (represented by strings) with each 2 digits.

Remarks:
if a result in seconds is ab.xy... it will be given truncated as ab.
if the given string is "" you will return ""


if it's empty return empty

else divide the string by the ", " pattern to get the individuals records
divide the string by "|" to get individual numbers and compile them into number of seconds for each record
if the index number %3 is 0 multiply by 3600, if it's 1 multiply by 60, else add it as is
*/

import java.util.Arrays;
import java.util.regex.Pattern;

public class StatisticTraining {

    public static String stat(String strg) {
        String range, average, median;
        if (strg.isEmpty())
            return "";
        String[] partOne = strg.split(Pattern.quote(", "));
        int numOfTeams = partOne.length;
        int[] individualNumbersToProcess = new int[partOne.length];
        int indexOfIndividualNumbers = 0;
        for (String s : partOne){
            String[] storageArray = s.split(Pattern.quote("|"));
            for (int i = 0; i < storageArray.length; i++){
                switch (i % 3) {
                    case 0:
                        individualNumbersToProcess[indexOfIndividualNumbers] += Integer.parseInt(storageArray[i]) * 3600;
                        break;
                    case 1:
                        individualNumbersToProcess[indexOfIndividualNumbers] += Integer.parseInt(storageArray[i]) * 60;
                        break;
                    case 2:
                        individualNumbersToProcess[indexOfIndividualNumbers] += Integer.parseInt(storageArray[i]);
                        break;
                }
            }
            indexOfIndividualNumbers++;
        }

        int rangeToCalculate = Arrays.stream(individualNumbersToProcess).max().getAsInt() - Arrays.stream(individualNumbersToProcess).min().getAsInt();
        int rangeInHours = rangeToCalculate / 3600;
        rangeToCalculate %= 3600;
        int rangeInMinutes = rangeToCalculate / 60;
        rangeToCalculate %= 60;
        range = String.format("%02d", rangeInHours) + "|" + String.format("%02d", rangeInMinutes) + "|" + String.format("%02d", rangeToCalculate);

        int averageToCalculate = Arrays.stream(individualNumbersToProcess).sum();
        averageToCalculate /= individualNumbersToProcess.length;
        int averageInHours = averageToCalculate / 3600;
        averageToCalculate %= 3600;
        int averageInMinutes = averageToCalculate / 60;
        averageToCalculate %= 60;
        average = String.format("%02d", averageInHours) + "|" + String.format("%02d", averageInMinutes) + "|" + String.format("%02d", averageToCalculate);

        individualNumbersToProcess = Arrays.stream(individualNumbersToProcess).sorted().toArray();
        if (individualNumbersToProcess.length % 2 == 1){
            int medianToCalculate = individualNumbersToProcess[individualNumbersToProcess.length / 2];
//            medianToCalculate /= individualNumbersToProcess.length;
            int medianInHours = medianToCalculate / 3600;
            medianToCalculate %= 3600;
            int medianInMinutes = medianToCalculate / 60;
            medianToCalculate %= 60;
            median = String.format("%02d", medianInHours) + "|" + String.format("%02d", medianInMinutes) + "|" + String.format("%02d", medianToCalculate);

        } else {
            int medianToCalculate = (individualNumbersToProcess[individualNumbersToProcess.length / 2] + individualNumbersToProcess[individualNumbersToProcess.length / 2 - 1]) /2;
//            medianToCalculate /= individualNumbersToProcess.length;
            int medianInHours = medianToCalculate / 3600;
            medianToCalculate %= 3600;
            int medianInMinutes = medianToCalculate / 60;
            medianToCalculate %= 60;
            median = String.format("%02d", medianInHours) + "|" + String.format("%02d", medianInMinutes) + "|" + String.format("%02d", medianToCalculate);

        }




        return "Range: " + range + " Average: " + average + " Median: " + median;
    }


}
