import java.util.Random;

public class UC7 {

    // Reusable method from UC6
    public static boolean placeMove(char[][] board, int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    // Display board
    public static void displayBoard(char[][] board) {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("--+---+--");
        }
    }

    // UC7: Computer makes random move
    public static void computerMove(char[][] board, char computerSymbol) {
        Random rand = new Random();
        boolean movePlaced = false;

        while (!movePlaced) {
            int slot = rand.nextInt(9) + 1; // 1–9

            // Convert slot to row & column
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            // Try placing move
            movePlaced = placeMove(board, row, col, computerSymbol);
        }

        System.out.println("\nComputer placed its move.");
    }

    public static void main(String[] args) {

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char computerSymbol = 'O';

        displayBoard(board);

        // Computer turn
        computerMove(board, computerSymbol);

        displayBoard(board);
    }
}