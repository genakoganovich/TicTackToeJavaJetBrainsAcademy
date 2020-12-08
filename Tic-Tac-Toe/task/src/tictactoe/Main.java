package tictactoe;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 3;

    public static void main(String[] args) {
        boolean isGameNotFinished = false;
        boolean isDraw = false;
        boolean doesXWin = false;
        boolean doesOWin = false;
        boolean isImpossible = false;
        boolean hasEmptyCells = false;
        boolean isBigDifference = false;

        boolean hasThreeOInRow = false;
        boolean hasThreeOInColumn = false;
        boolean hasThreeOInDiagonal = false;


        boolean hasThreeXInRow = false;
        boolean hasThreeXInColumn = false;
        boolean hasThreeXInDiagonal = false;


        //======================================================
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.next();
        char[] cells = input.toCharArray();
        scanner.nextLine();
        //=======================================================
        // print the field
        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cells[i * SIZE + j] + " ");
            }
            System.out.println("|");
        }

        for (int i = 0; i < cells.length; i++) {
            System.out.print("-");
        }
        System.out.println();

        //=============================================================
        // calculate sum in rows
        int[] rowSum = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rowSum[i] += cells[j + i * SIZE];
            } // for j
        } // for i

        //==============================================================
        // calculate sum in columns
        int[] colSum = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colSum[i] += cells[i + j * SIZE];
            } // for j
        }

        //==============================================================
        // calculate sum in diagonals
        int[] sumDiag = new int[2];
        for (int j = 0; j < SIZE; j++) {
            sumDiag[0] += cells[(SIZE + 1) * j];
        }
        for (int j = 0; j < SIZE; j++) {
            sumDiag[1] += cells[(SIZE - 1) + (SIZE - 1) * j];
        }

        //==============================================================
        // calculate X number
        int xNumber = 0;
        for (char c : cells) {
            if (c == 'X') {
                xNumber++;
            }
        }

        //==============================================================
        // calculate O number
        int oNumber = 0;
        for (char c : cells) {
            if (c == 'O') {
                oNumber++;
            }
        }

        //==============================================================
        // calculating hasThree... flags

        for (int i = 0; i < SIZE; i++) {
            if (rowSum[i] == 264) {
                hasThreeXInRow = true;
            }
            if (rowSum[i] == 237) {
                hasThreeOInRow = true;
            }
            if (colSum[i] == 264) {
                hasThreeXInColumn = true;
            }
            if (colSum[i] == 237) {
                hasThreeOInColumn = true;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (sumDiag[i] == 264) {
                hasThreeXInDiagonal = true;
            }
            if (sumDiag[i] == 237) {
                hasThreeOInDiagonal = true;
            }
        }

        //==============================================================
        // calculate final flags
        doesXWin = hasThreeXInRow || hasThreeXInColumn || hasThreeXInDiagonal;
        doesOWin = hasThreeOInRow || hasThreeOInColumn || hasThreeOInDiagonal;
        hasEmptyCells = String.valueOf(cells).contains("_");
        if (Math.abs(xNumber - oNumber) > 1) {
            isBigDifference = true;
        }
        isImpossible = doesOWin && doesXWin || isBigDifference;
        isDraw = !isImpossible && !doesOWin && !doesXWin && !hasEmptyCells;
        isGameNotFinished = !isImpossible && !doesOWin && !doesXWin && hasEmptyCells;

        //==============================================================
        // print results
//        if (isImpossible) {
//            System.out.println("Impossible");
//        } else if (isGameNotFinished) {
//            System.out.println("Game not finished");
//        } else if (isDraw) {
//            System.out.println("Draw");
//        } else if (doesXWin) {
//            System.out.println("X wins");
//        } else {
//            System.out.println("O wins");
//        }

        //==============================================================
        // get the coordinates from a user
        String[] values;
        int x, y;
        int index = 0;
        boolean areValidCoordinates = false;
        while (!areValidCoordinates) {
            System.out.print("Enter the coordinates: ");
            values = scanner.nextLine().split(" ");
            if (values.length != 2 || !values[0].matches("\\d") || !values[1].matches("\\d")) {
                System.out.println("You should enter numbers!");
            } else if (!"123".contains(values[0]) || !"123".contains(values[1])){
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                x = Integer.parseInt(values[0]);
                y = Integer.parseInt(values[1]);
                index = (x - 1) + (SIZE - y) * SIZE;
                if (cells[(x - 1) + (SIZE - y) * SIZE]!= '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    areValidCoordinates = true;
                }
            }
        } // while
        cells[index] = 'X';

        //=======================================================
        // print the field again
        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cells[i * SIZE + j] + " ");
            }
            System.out.println("|");
        }

        for (int i = 0; i < cells.length; i++) {
            System.out.print("-");
        }
        System.out.println();

    } // main
} // class Main
