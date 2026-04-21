import java.util.Random;
import java.util.Scanner;

public class UC5 {

    // UC5: Board initialization
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

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

        // UC4: Convert slot → row & column
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        System.out.println("Mapped Position -> Row: " + row + ", Column: " + col);

        // UC5: Validate move
        if (isValidMove(row, col)) {
            System.out.println("Move is valid ✅");
        } else {
            System.out.println("Invalid move ❌");
        }
    }

    // UC3
    static int getUserSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // UC4
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // UC5
    static boolean isValidMove(int row, int col) {

        // Boundary check
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        return board[row][col] == '-';
    }
}