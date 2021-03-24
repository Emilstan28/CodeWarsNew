package com.company;

/*https://www.codewars.com/kata/5853213063adbd1b9b0000be

Selection Grid Layout in text:

| Ryu  | E.Honda | Blanka  | Guile   | Balrog | Vega    |
| Ken  | Chun Li | Zangief | Dhalsim | Sagat  | M.Bison |
Input

the list of game characters in a 2x6 grid;
the initial position of the selection cursor (top-left is (0,0));
a list of moves of the selection cursor (which are up, down, left, right);
Output

the list of characters who have been hovered by the selection cursor after all the moves (ordered and with repetition, all the ones after a move, wether successful or not, see tests);
Rules

Selection cursor is circular horizontally but not vertically!

As you might remember from the game, the selection cursor rotates horizontally but not vertically; that means that if I'm in the leftmost and I try to go left again I'll get to the rightmost (examples: from Ryu to Vega, from Ken to M.Bison) and vice versa from rightmost to leftmost.

Instead, if I try to go further up from the upmost or further down from the downmost, I'll just stay where I am located (examples: you can't go lower than lowest row: Ken, Chun Li, Zangief, Dhalsim, Sagat and M.Bison in the above image; you can't go upper than highest row: Ryu, E.Honda, Blanka, Guile, Balrog and Vega in the above image).

Test

For this easy version the fighters grid layout and the initial position will always be the same in all tests, only the list of moves change.

Notice: changing some of the input data might not help you.
*/

public class StreetFighterSelect {

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        String[] fightersHoveredOver = new String[moves.length];
        int vertical = position[0];
        int horizontal = position[1];
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case "up":
                    if (vertical != 0) {
                        vertical--;
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
                case "down":
                    if (vertical != 1) {
                        vertical++;
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
                case "right":
                    if (horizontal == fighters[vertical].length - 1){
                        horizontal = 0;
                    } else {
                        horizontal++;
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
                case "left":
                    if (horizontal == 0){
                        horizontal = fighters[vertical].length - 1;
                    } else {
                        horizontal--;
                    }
                    fightersHoveredOver[i] = fighters[vertical][horizontal];
                    break;
            }
        }
        return fightersHoveredOver;
    }

}
