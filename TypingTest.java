import java.util.Scanner;

public class TypingSpeedTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = "Java is super cool!";
        
        System.out.println("Type this as fast as you can: \n" + sentence);
        System.out.print("Press ENTER when ready...");
        sc.nextLine();
        
        long startTime = System.currentTimeMillis();
        System.out.print("Start typing: ");
        String userInput = sc.nextLine();
        long endTime = System.currentTimeMillis();
        
        if (userInput.equals(sentence)) {
            double timeTaken = (endTime - startTime) / 1000.0;
            System.out.println("Great job! You took " + timeTaken + " seconds.");
        } else {
            System.out.println("Oops! You made a typo.");
        }
        
        sc.close();
    }
}
