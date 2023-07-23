import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadders {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    // Set up the board
    int[] board = new int[100];
    for (int i = 0; i < board.length; i++) {
      board[i] = i + 1;
    }
    board[3] = 22;
    board[5] = 8;
    board[11] = 26;
    board[20] = 29;
    board[17] = 4;
    board[19] = 7;
    board[21] = 9;
    board[27] = 1;
    board[50] = 51;
    board[54] = 36;
    board[62] = 19;
    board[64] = 60;
    board[71] = 91;
    board[87] = 24;
    board[93] = 73;
    board[95] = 75;
    board[98] = 78;

    // Set up the player positions
    int[] positions = new int[2];
    positions[0] = 0;
    positions[1] = 0;
    int currentPlayer = 0;

    // Start the game loop
    while (true) {
      // Print the current player and their position
      System.out.println("Player " + (currentPlayer + 1) + " is on square " + board[positions[currentPlayer]]);

      // Roll the dice
      int diceRoll = rand.nextInt(6) + 1;
      System.out.println("They rolled a " + diceRoll);

      // Move the player
      positions[currentPlayer] += diceRoll;
      if (positions[currentPlayer] > 99) {
        positions[currentPlayer] = 99;
      }

      // Check if the player has landed on a ladder or a snake
      int oldPosition = positions[currentPlayer] - diceRoll;
      if (board[positions[currentPlayer]] < board[oldPosition]) {
        System.out.println("Oh no! You landed on a snake and went back to square " + board[positions[currentPlayer]]);
      } else if (board[positions[currentPlayer]] > board[oldPosition]) {
        System.out.println("Yay! You landed on a ladder and went up to square " + board[positions[currentPlayer]]);
      }

      // Check if the game is over
      if (board[positions[currentPlayer]] == 100) {
        System.out.println("Player " + (currentPlayer + 1) + " wins!");
        break;
      }

      // Switch to the other player
      currentPlayer = (currentPlayer + 1) % 2;
    }
  }
}
