import java.util.*;

public class ShutTheBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tiles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean[] lowered = {false, false, false, false, false, false, false, false, false};
        
        System.out.println("Welcome to Shut the Box!");
        
        while (true) {
            System.out.println("Press enter to roll the dice...");
            scanner.nextLine();
            
            int dice1 = rollDice();
            int dice2 = rollDice();
            int total = dice1 + dice2;
            
            System.out.println("You rolled " + dice1 + " and " + dice2 + " (total = " + total + ")");
            
            if (canLowerTiles(total, lowered)) {
                System.out.println("Which tiles do you want to lower? (comma separated)");
                String input = scanner.nextLine();
                String[] selections = input.split(",");
                
                for (String selection : selections) {
                    int tileNum = Integer.parseInt(selection.trim());
                    
                    if (!lowered[tileNum - 1]) {
                        lowered[tileNum - 1] = true;
                    }
                }
            } else {
                System.out.println("Sorry, there are no tiles left to lower with that roll.");
            }
            
            if (isGameFinished(lowered)) {
                System.out.println("Congratulations, you lowered all the tiles!");
                resetTiles(lowered);
            }
        }
    }
    
    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public static boolean canLowerTiles(int total, boolean[] lowered) {
        for (int i = 0; i < lowered.length; i++) {
            if (!lowered[i] && tiles[i] <= total) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isGameFinished(boolean[] lowered) {
        for (boolean loweredTile : lowered) {
            if (!loweredTile) {
                return false;
            }
        }
        return true;
    }
    
    public static void resetTiles(boolean[] lowered) {
        for (int i = 0; i < lowered.length; i++) {
            lowered[i] = false;
        }
    }

import java.util.*;

public class ShutTheBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tiles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean[] lowered = {false, false, false, false, false, false, false, false, false};
        
        System.out.println("Welcome to Shut the Box!");
        
        while (true) {
            System.out.println("Press enter to roll the dice...");
            scanner.nextLine();
            
            int dice1 = rollDice();
            int dice2 = rollDice();
            int total = dice1 + dice2;
            
            System.out.println("You rolled " + dice1 + " and " + dice2 + " (total = " + total + ")");
            
            if (canLowerTiles(total, lowered)) {
                System.out.println("Which tiles do you want to lower? (comma separated)");
                String input = scanner.nextLine();
                String[] selections = input.split(",");
                
                for (String selection : selections) {
                    int tileNum = Integer.parseInt(selection.trim());
                    
                    if (!lowered[tileNum - 1]) {
                        lowered[tileNum - 1] = true;
                    }
                }
            } else {
                System.out.println("Sorry, there are no tiles left to lower with that roll.");
            }
            
            if (isGameFinished(lowered)) {
                System.out.println("Congratulations, you lowered all the tiles!");
                resetTiles(lowered);
            }
        }
    }
    
    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public static boolean canLowerTiles(int total, boolean[] lowered) {
        for (int i = 0; i < lowered.length; i++) {
            if (!lowered[i] && tiles[i] <= total) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isGameFinished(boolean[] lowered) {
        for (boolean loweredTile : lowered) {
            if (!loweredTile) {
                return false;
            }
        }
        return true;
    }
    
    public static void resetTiles(boolean[] lowered) {
        for (int i = 0; i < lowered.length; i++) {
            lowered[i] = false;
        }
    }

}
}
