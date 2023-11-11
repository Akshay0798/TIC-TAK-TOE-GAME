import java.util.Scanner;

public class ImprovedTicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // Initialize the game board with empty spaces
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " Enter: ");
            
            // Improved input validation: Ensure the entered move is within the board boundaries and the chosen position is empty
            int row = -1;
            int col = -1;
            boolean validMove = false;

            while (!validMove) {
                row = sc.nextInt();
                col = sc.nextInt();

                if (row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == ' ') {
                    validMove = true;
                } else {
                    System.out.println("Invalid Move. Try Again");
                }
            }

            board[row][col] = player; // Place the player's symbol in the selected position
            gameOver = WhoHaveWon(board, player);

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
        }
    }

    // Function to check if a player has won
    private static boolean WhoHaveWon(char[][] board, char player) {
        // Check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // Check the columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // Check the diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
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
