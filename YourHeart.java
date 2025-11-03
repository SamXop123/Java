
// Heart Pattern

public class YourHeart {
    public static void main(String[] args) {
      
        final int size = 4  ;  

        // upper part of Heart  
        for (int m = 0; m < size; m++) {  

            for (int k = 0; k <= 4 * size; k++) {  

                double pos1 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(k - size, 2));  
                double pos2 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(k - 3 * size, 2));  

                if (pos1 < size + 0.5 || pos2 < size + 0.5) {  
                        System.out.print('*');  
                } 
                else {  
                        System.out.print(' ');  
                }  
            }  
            System.out.print(System.lineSeparator());  
        }  

            // lower part of Heart  
            for (int m = 1; m <= 2 * size; m++)  {  

                for (int k = 0; k < m; k++) {  

                    System.out.print(' ');  
            }  

            for (int k = 0; k < 4 * size + 1 - 2 * m; k++) {  

                System.out.print("*");  
            }  
            System.out.print(System.lineSeparator());  
            }  
            System.out.println();

   }
}   
