import java.util.Scanner;

public class Pseudocu {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Set up the board and player pieces
    int[] board = new int[14];
    for (int i = 0; i < board.length; i++) {
      board[i] = 4;
    }
    int[] pieces = new int[2];
    pieces[0] = 0;
    pieces[1] = 0;
    int currentPlayer = 0;

    // Start the game loop
    while (true) {
      // Print the current player and the board
      System.out.println("Player " + (currentPlayer + 1) + " is up");
      for (int i = 0; i < board.length; i++) {
        System.out.print(board[i] + " ");
      }
      System.out.println();

      // Get the player's choice of row
      System.out.print("Choose a row (1-7): ");
      int row = sc.nextInt();
      row--;

      // Make sure the row is valid
      if (row < 0 || row >= 7 || board[row] == 0) {
        System.out.println("Invalid choice");
        continue;
      }

      // Take the piece from the row
      board[row]--;

      // Distribute the pieces in the row
      for (int i = row + 1; i < board.length; i++) {
        board[i]++;
      }

      // Check if the player gets another turn
      if (board[row] == 0) {
        System.out.println("You get another turn!");
      } else {
        currentPlayer = (currentPlayer + 1) % 2;
      }

      // Check if the game is over
      boolean gameOver = true;
      for (int i = 0; i < 7; i++) {
        if (board[i] > 0) {
          gameOver = false;
          break;
        }
      }
      if (gameOver) {
        int winner = (currentPlayer + 1) % 2;
        System.out.println("Player " + (winner + 1) + " wins!");
        break;
      }
    }
  }
}
