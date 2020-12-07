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
        System.out.print("Enter cells: ");
        String input = new Scanner(System.in).next();

        //=======================================================
        // print the field
        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(input.charAt(i * SIZE + j) + " ");
            }
            System.out.println("|");
        }

        for (int i = 0; i < input.length(); i++) {
            System.out.print("-");
        }
        System.out.println();

        //=============================================================
        // calculate sum in rows
        int[] rowSum = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rowSum[i] += input.charAt(j + i * SIZE);
            } // for j
        } // for i

        //==============================================================
        // calculate sum in columns
        int[] colSum = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colSum[i] += input.charAt(i + j * SIZE);
            } // for j
        }

        //==============================================================
        // calculate sum in diagonals
        int[] sumDiag = new int[2];
        for (int j = 0; j < SIZE; j++) {
            sumDiag[0] += input.charAt((SIZE + 1) * j);
        }
        for (int j = 0; j < SIZE; j++) {
            sumDiag[1] += input.charAt((SIZE - 1) + (SIZE - 1) * j);
        }

        //==============================================================
        // calculate X number
        int xNumber = 0;
        for (char c : input.toCharArray()) {
            if (c == 'X') {
                xNumber++;
            }
        }

        //==============================================================
        // calculate O number
        int oNumber = 0;
        for (char c : input.toCharArray()) {
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
        hasEmptyCells = input.contains("_");
        if (Math.abs(xNumber - oNumber) > 1) {
            isBigDifference = true;
        }
        isImpossible = doesOWin && doesXWin || isBigDifference;
        isDraw = !isImpossible && !doesOWin && !doesXWin && !hasEmptyCells;
        isGameNotFinished = !isImpossible && !doesOWin && !doesXWin && hasEmptyCells;

        //==============================================================
        // print results
        if (isImpossible) {
            System.out.println("Impossible");
        } else if (isGameNotFinished) {
            System.out.println("Game not finished");
        } else if (isDraw) {
            System.out.println("Draw");
        } else if (doesXWin) {
            System.out.println("X wins");
        } else {
            System.out.println("O wins");
        }
    }
}
