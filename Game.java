// Basic Idea of the game
// 1. User starts the game
//     a. Game creates three Dot Coms.
//     b. Game places the three Dot Coms onto a virtual grid.
// 2. Game play begins
//     Repeat the following until there are no more Dot Coms:
//         A. Prompt user for a guess ("A2","C0", etc.)
//         B. Check the user guess against all Dot Coms to look for a hit, miss, or kill. Take appropriate action: if a hit delete cell (A2, D4, etc.). If a kill, delete the Dot Com.
// 3. Game finishes
//     Give the user a rating based on the number of guesses.

import java.util.Scanner;

class SimpleDotCom {
    int [] cellLocations;
    int numOfHits;

    void setCellLocations(int[] locations) {
        cellLocations = locations;
    }
    String checkTheGuess(String userGuess) {
        String result = "miss";
        int guess = Integer.parseInt(userGuess);
        for (int i = 0; i < cellLocations.length; i++) {
            if (guess == cellLocations[i]) {
                result = "hit";
                numOfHits += 1;
                cellLocations[i] = -100;
                break;
            }
        }
        if (numOfHits == cellLocations.length) {
                result = "kill";
            }
        System.out.println(result);
        return result;
    }
}

public class Game {
    public static void main(String[] args) {
        // Instantiating Scanner object
        Scanner input = new Scanner(System.in);
        // Instantiating SimpleDotCom object
        SimpleDotCom dot = new SimpleDotCom();
        // Integer var to hold user rating
        int numOfGuesses = 0;
        // Instantiating cell array and randomly assigning locations of cells
        int[] cells = new int[3];
        int firstCell = (int) (Math.random() * 5);
        cells[0] = firstCell;
        for (int i = 1; i < 3; i++) {
            cells[i] = firstCell + i;
        }
        // setting dot object's cell locations
        dot.setCellLocations(cells);
        System.out.println("Let's Start the Game!");
        // Loop until the user guesses all the cell locations and wins the game.
        while (true) {
            System.out.print("Enter a guess  ");
            String userGuess = input.nextLine();
            // Cheks if guessed correctly
            String result = dot.checkTheGuess(userGuess);
            // Increment number of attempts
            numOfGuesses += 1;
            if (result == "kill") {
                System.out.println("Ouch! You sunk the ship!");
                System.out.println("You took 4 guesses");
                break;
            }
        }

        // System.out.println(testResult);

    }
}
