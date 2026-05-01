public class UC10 {

    // UC10: Check draw condition
    public static boolean isDraw(char[][] board) {

        // Traverse entire board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If any empty cell exists → not a draw
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        // No empty cells → draw
        return true;
    }

    // Test
    public static void main(String[] args) {

        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };

        if (isDraw(board)) {
            System.out.println("It's a Draw!");
        } else {
            System.out.println("Game still in progress.");
        }
    }
}