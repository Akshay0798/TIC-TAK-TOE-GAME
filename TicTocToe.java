import java.util.Scanner;

public class TicTocToe {
    public static void main(String[] args) {
        // Initialize a 3x3 board with empty spaces
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        
        char player = 'X'; // Starting player
        boolean gameOver = false; // Game continuation flag

        Scanner sc = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board); // Display the current state of the board
            System.out.println("Player " + player + " Enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Check if the selected position is empty
            if (board[row][col] == ' ') {
                board[row][col] = player; // Place the player's symbol in the selected position
                gameOver = WhoHaveWon(board, player); // Check if the player has won

                // Display the winner if the game is over, otherwise, switch to the next player
                if (gameOver) {
                    System.out.println("Player " + player + " has Won:");
                } else {
                    // Switch player for the next turn
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid Move. Try Again");
            }
        }
    }

    // Function to check if a player has won
    private static boolean WhoHaveWon(char[][] board, char player) {
        // Check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        // Check the columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        // Check the diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    // Function to print the current state of the board
    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " || ");
            }
            System.out.println();
        }
    }
}
