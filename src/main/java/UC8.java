import java.util.Scanner;
import java.util.Random;

public class UC8 {

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

    // UC6: Place move
    public static boolean placeMove(char[][] board, int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    // UC7: Computer random move
    public static void computerMove(char[][] board, char symbol) {
        Random rand = new Random();
        boolean placed = false;

        while (!placed) {
            int slot = rand.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            placed = placeMove(board, row, col, symbol);
        }
        System.out.println("Computer played.");
    }

    // Check win
    public static boolean checkWin(char[][] board, char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == s && board[i][1] == s && board[i][2] == s) return true;
            if (board[0][i] == s && board[1][i] == s && board[2][i] == s) return true;
        }
        if (board[0][0] == s && board[1][1] == s && board[2][2] == s) return true;
        if (board[0][2] == s && board[1][1] == s && board[2][0] == s) return true;

        return false;
    }

    // Check draw
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char human = 'X';
        char computer = 'O';
        boolean humanTurn = true;
        boolean gameOver = false;

        System.out.println("Tic-Tac-Toe Game Started!");

        while (!gameOver) {

            displayBoard(board);

            if (humanTurn) {
                System.out.print("Enter row (0-2): ");
                int row = sc.nextInt();
                System.out.print("Enter col (0-2): ");
                int col = sc.nextInt();

                if (!placeMove(board, row, col, human)) {
                    System.out.println("Invalid move, try again.");
                    continue; // retry same turn
                }

                if (checkWin(board, human)) {
                    displayBoard(board);
                    System.out.println("You Win!");
                    gameOver = true;
                }

            } else {
                computerMove(board, computer);

                if (checkWin(board, computer)) {
                    displayBoard(board);
                    System.out.println("Computer Wins!");
                    gameOver = true;
                }
            }

            // Check draw
            if (!gameOver && isDraw(board)) {
                displayBoard(board);
                System.out.println("It's a Draw!");
                gameOver = true;
            }

            // Switch turn
            humanTurn = !humanTurn;
        }

        sc.close();
    }
}