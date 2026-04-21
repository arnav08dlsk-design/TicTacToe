import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        String player1 = "Player 1";
        String player2 = "Player 2";

        char player1Symbol, player2Symbol;
        String currentPlayer;
        char currentSymbol;

        // Random toss
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayer = player1;
            currentSymbol = player1Symbol;
        } else {
            player1Symbol = 'O';
            player2Symbol = 'X';
            currentPlayer = player2;
            currentSymbol = player2Symbol;
        }

        // Display results
        System.out.println("Toss Result:");
        System.out.println(player1 + " is " + player1Symbol);
        System.out.println(player2 + " is " + player2Symbol);
        System.out.println(currentPlayer + " starts first with symbol " + currentSymbol);

        // UC3: Take user input
        int slot = getUserSlot();
        System.out.println(currentPlayer + " selected slot: " + slot);
    }

    static int getUserSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }
}
