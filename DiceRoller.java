import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of dice to roll: ");
        int numDice = sc.nextInt();
        
        System.out.print("Rolling... 🎲🎲🎲\n");
        for (int i = 0; i < numDice; i++) {
            System.out.println("Die " + (i + 1) + ": " + (rand.nextInt(6) + 1));
        }
        
        sc.close();
    }
}
