package com.company;


/*
* https://www.codewars.com/kata/58583922c1d5b415b00000ff/java
* */
public class SuperStreetFighterChoice {
    public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
        String[] fightersHoveredOver = new String[moves.length];
        int vertical = position[0];
        int horizontal = position[1];
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case "up":
                    if (vertical != 0 && !fighters[vertical - 1][horizontal].isEmpty()) {
                        vertical--;
                    } else {
                        for (int j = vertical; j > -1; j--){
                            if (!fighters[vertical][horizontal].isEmpty()) {
                                vertical = j;
                                break;
                            }
                        }
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
                case "down":
                    if (vertical != fighters.length - 1 && !fighters[vertical + 1][horizontal].isEmpty()) {
                        vertical++;
                    } else {
                        for (int j = vertical; j < fighters.length; j++) {
                            if (!fighters[vertical][horizontal].isEmpty()) {
                                vertical = j;
                                break;
                            }
                        }
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
                case "right":
                    if (horizontal != fighters[vertical].length - 1 && !fighters[vertical][horizontal + 1].isEmpty()){
                        horizontal++;
                    } else {
                        for (int j = horizontal; j < fighters[vertical].length; j++) {
                            if (j == fighters[vertical].length - 1)
                            j = - 1;
                            if (!fighters[vertical][j + 1].isEmpty()) {
                                j++;
                                horizontal = j;
                                break;
                            }

                        }
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
                case "left":
                    if (horizontal != 0 && !fighters[vertical][horizontal - 1].isEmpty()){
                        horizontal--;
                    } else {
                        for (int j = horizontal; j > -1; j--) {
                            if (j == 0)
                                j = fighters[vertical].length;
                            if (!fighters[vertical][j - 1].isEmpty()) {
                                j--;
                                horizontal = j;
                                break;
                            }
                        }
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
            }
        }
        return fightersHoveredOver;
    }
}
