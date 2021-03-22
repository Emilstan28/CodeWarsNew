package com.company;

/*Make me a window. I'll give you a number (N). You return a window.

Rules:

The window will always be 2 x 2.

The window needs to have N number of periods across and N number of periods vertically in each pane.

Example:

N = 3

---------
|...|...|
|...|...|
|...|...|
|---+---|
|...|...|
|...|...|
|...|...|
---------
*/

public class MakeAWindow {
    public static String makeAWindow(int num) {
        int numberForConstruction = num * 2 + 3;
        String solution = "";
        for (int vertical = 0; vertical < numberForConstruction; vertical++) {
            if (vertical == 0 || vertical == numberForConstruction - 1) {
                if (vertical != 0) {
                    solution = solution.concat("\n");
                }
                for (int horizontal = 0; horizontal < numberForConstruction; horizontal++) {
                    solution = solution.concat("-");
                }
            } else if (vertical == numberForConstruction / 2) {
                solution = solution.concat("\n");
                for (int horizontal = 0; horizontal < numberForConstruction; horizontal++) {
                    if (horizontal == 0 || horizontal == numberForConstruction - 1) {
                        solution = solution.concat("|");
                    } else if (horizontal == numberForConstruction / 2) {
                        solution = solution.concat("+");
                    } else {
                        solution = solution.concat("-");
                    }
                }
            } else {
                solution = solution.concat("\n");
                for (int horizontal = 0; horizontal < numberForConstruction; horizontal++) {
                    if (horizontal == 0 || horizontal == numberForConstruction - 1 || horizontal == numberForConstruction / 2) {
                        solution = solution.concat("|");
                    } else {
                        solution = solution.concat(".");
                    }
                }
            }
        }
        return solution;
    }
}
