import java.util.Random;

public class UC2 {
    public static void main(String[] args) {

        String player1 = "Player 1";
        String player2 = "Player 2";

        char player1Symbol, player2Symbol;
        String currentPlayer;
        char currentSymbol;

        // Random toss
        Random rand = new Random();
        int toss = rand.nextInt(2); // 0 or 1

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
    }
}
