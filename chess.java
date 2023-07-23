import java.util.Scanner;

public class Chess {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Set up the board
    String[][] board = new String[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = " ";
      }
    }
    board[0][0] = "R";
    board[0][1] = "N";
    board[0][2] = "B";
    board[0][3] = "Q";
    board[0][4] = "K";
    board[0][5] = "B";
    board[0][6] = "N";
    board[0][7] = "R";
    for (int i = 0; i < 8; i++) {
      board[1][i] = "P";
    }
    board[7][0] = "r";
    board[7][1] = "n";
    board[7][2] = "b";
    board[7][3] = "q";
    board[7][4] = "k";
    board[7][5] = "b";
    board[7][6] = "n";
    board[7][7] = "r";
    for (int i = 0; i < 8; i++) {
      board[6][i] = "p";
    }

    // Set up the player turn
    int turn = 0;

    // Start the game loop
    while (true) {
      // Print the board
      System.out.println("  A B C D E F G H");
      for (int i = 0; i < 8; i++) {
        System.out.print((8 - i) + " ");
        for (int j = 0; j < 8; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }

      // Get the player's move
      System.out.print("Enter your move (e.g. E2 E4): ");
      String start = sc.next();
      String end = sc.next();

      // Validate the player's move
      int startX = start.charAt(0) - 'A';
      int startY = 8 - (start.charAt(1) - '0');
      int endX = end.charAt(0) - 'A';
      int endY = 8 - (end.
