import java.util.Scanner;

public class UC6 {

    // Display the board
    public static void displayBoard(char[][] board) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("--+---+--");
        }
    }

    // UC6: Place Move on Board
    public static boolean placeMove(char[][] board, int row, int col, char symbol) {
        // Check valid move
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = symbol;  // State update
            return true;
        } else {
            System.out.println("Invalid move! Try again.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char symbol = 'X'; // Example player

        displayBoard(board);

        System.out.print("\nEnter row (0-2): ");
        int row = sc.nextInt();

        System.out.print("Enter column (0-2): ");
        int col = sc.nextInt();

        if (placeMove(board, row, col, symbol)) {
            System.out.println("\nMove placed successfully!");
        }

        displayBoard(board);

        sc.close();
    }
}