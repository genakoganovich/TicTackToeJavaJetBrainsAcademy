package tictactoe;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 3;

    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String input = new Scanner(System.in).next();
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
    }
}
