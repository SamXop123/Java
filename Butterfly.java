
// Butterfly Pattern

public class Pattern {
    public static void main(String args[]) {

        int n = 5;

        // Upper part
        for (int i = 1; i <= n; i++) {
            String stars = "*".repeat(i);                
            String spaces = " ".repeat(2 * (n - i));     

            System.out.println(stars + spaces + stars); 
        }

        // Lower part
        for (int i = n; i >= 1; i--) {
            String stars = "*".repeat(i);                
            String spaces = " ".repeat(2 * (n - i));     

            System.out.println(stars + spaces + stars);  
        }
        System.out.println();

    }
}
