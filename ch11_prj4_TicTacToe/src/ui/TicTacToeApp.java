package ui;

import util.Console;

public class TicTacToeApp {

    public static void main(String[] args) {

        Console.displayLine("Welcome to Tic Tac Toe");

        String[][] grid = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " ";
            }
        }

        displayGrid(grid);

        boolean gamePlaying = true;
        String currentPlayer = "O";

        while (gamePlaying) {
            if (currentPlayer.equals("O")) {
                currentPlayer = "X";
            } else {
                currentPlayer = "O";
            }

            Console.displayLine();
            Console.displayLine(currentPlayer + "'s turn");
            boolean guessNotValid = true;

            while (guessNotValid) {
                int i = Console.getInt("Pick a row (1, 2, 3): ", 1, 3);
                int j = Console.getInt("Pick a column ( 1, 2, 3): ", 1, 3);

                i--;
                j--;

                if (grid[i][j].equals(" ")) {
                    grid[i][j] = currentPlayer;
                    guessNotValid = false;
                } else {
                    Console.displayLine("That cell has already been played. Pick again.");
                }
            }

            displayGrid(grid);

            // logic to determine if currentPlayer wins the game
            for (int i = 0; i < 3; i++) {
                if ((grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2])) && (!grid[i][0].equals(" "))) {
                    gamePlaying = false;
                } else if ((grid[0][i].equals(grid[1][i]) && grid[1][i].equals(grid[2][i])) && (!grid[0][i].equals(" "))) {
                    gamePlaying = false;
                }
            }

            if ((grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])) && (!grid[0][0].equals(" "))) {
                gamePlaying = false;
            }

            if ((grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])) && (!grid[0][2].equals(" "))) {
                gamePlaying = false;
            }

        }

        Console.displayLine();
        Console.displayLine(currentPlayer + " wins!");
        Console.displayLine("\nGame over!");
    }

    public static void displayGrid(String[][] grid) {
        Console.displayLine();
        displayHorizontal();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + grid[i][j] + " ");
            }
            System.out.print("|\n");
            displayHorizontal();
        }
    }

    public static void displayHorizontal() {
        Console.displayLine("+---+---+---+");
    }
}
