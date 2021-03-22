package com.company;

/*https://www.codewars.com/kata/5855777bb45c01bada0002ac/train/java
*
* Turning an input string into a color coded band of 4 colours
* All resistors have at least three bands, with the first and second bands indicating the first two digits of the ohms value,
*  and the third indicating the power of ten to multiply them by
* 0: black, 1: brown, 2: red, 3: orange, 4: yellow, 5: green, 6: blue, 7: violet, 8: gray, 9: white */

import java.util.*;
public class Resistors {


    public static String encodeResistorColors(String ohmsString) {
        String first, second, third;
        int isHundredOrSingleDigit = 0;
        boolean isK = false;
        boolean isM = false;

        char[] characters = ohmsString.toCharArray();

        for (char c :characters){
            if (c == 'k')
                isK = true;
            if (c == 'M')
                isM = true;
        }

        HashMap<Integer, String> values = new HashMap<>();
        values.put(0,"black ");
        values.put(1,"brown ");
        values.put(2,"red ");
        values.put(3,"orange ");
        values.put(4,"yellow ");
        values.put(5,"green ");
        values.put(6,"blue ");
        values.put(7,"violet ");
        values.put(8,"gray ");
        values.put(9,"white ");

        if (characters[1] == '.'){
            first = values.get(Character.getNumericValue(characters[0]));
            second = values.get(Character.getNumericValue(characters[2]));

            if (isK)
                third = values.get(2);
            else if (isM)
                third = values.get(5);
            else
                third = values.get(0);
        } else {
            first = values.get(Character.getNumericValue(characters[0]));

            if (Character.isDigit(characters[2])){
                isHundredOrSingleDigit = 1;
            } else if (!Character.isDigit(characters[1]))
                isHundredOrSingleDigit = -1;

            if (Character.isDigit(characters[1]))
                second = values.get(Character.getNumericValue(characters[1]));
            else
                second = values.get(0);

            if (isK)
                third = values.get(3 + isHundredOrSingleDigit);
            else if (isM)
                third = values.get(6 + isHundredOrSingleDigit);
            else if (Character.isDigit(characters[2]))
                third = values.get(1);
            else
                third = values.get(0);
        }

        String answer;

        answer = first + second + third + "gold";

        return answer;
    }
}
