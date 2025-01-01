
// Bubble Sort, Selection Sort & Insertion Sort

import java.util.*;

public class Sorting {

    public static void printArray(int array[]) {
        for(int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
  
    public static void main(String args[]) {
      
        Scanner sc = new Scanner(System.in);

        //! BUBBLE SORT
        //  if arr[i] > arr[i+1] swap them. To place the element in their respective position, we have to do the following operation N-1 times. 
        // Time complexity is --- O(n^2) --- (Big O of n square)

        System.out.println("Enter the size for your array: ");
        int size = sc.nextInt();
        System.out.println("Enter your array: ");
        int [] arrBubble = new int[size];

        //Input the array
        for(int i = 0; i < arrBubble.length; i++) {
            arrBubble[i] = sc.nextInt();
        }

        //Output the array entered
        System.out.println("You entered: ");
        for(int k = 0; k<arrBubble.length; k++) {
            System.out.print(arrBubble[k] + " ");
        }
        System.out.println();

        //Sorting Mechanism
        for(int i = 0; i < arrBubble.length-1; i++) {
            for(int j = 0; j < arrBubble.length-i-1; j++) {
                if(arrBubble[j] > arrBubble[j+1]) {
                    int temp = arrBubble[j];
                    arrBubble[j] = arrBubble[j+1];
                    arrBubble[j+1] = temp;

                }
            }
        }
        System.out.println("The Sorted array is: ");
        printArray(arrBubble);


        System.out.println("------------------------------------");


        //! SELECTION SORT  
        // The inner loop selects the minimum element in the unsorted array and places the elements in increasing order. 
        // Time complexity = O(n^2) 


        System.out.println("Enter the size for your array: ");
        int sizes = sc.nextInt();
        System.out.println("Enter your array: ");
        int [] arrSelect = new int[sizes];

        //Input the array
        for(int i = 0; i < arrSelect.length; i++) {
            arrSelect[i] = sc.nextInt();
        }

        //Output the array entered
        System.out.println("You entered: ");
        for(int k = 0; k<arrSelect.length; k++) {
            System.out.print(arrSelect[k] + " ");
        }
        System.out.println();
        

        //Sorting Mechanism
        for(int i = 0; i < arrSelect.length; i++) {

            int smallest = i;

            for(int j = i+1; j < arrSelect.length; j++) {
                if(arrSelect[smallest] > arrSelect[j]) {
                    smallest = j;
                }
            }

            int temp = arrSelect[smallest];
            arrSelect[smallest] = arrSelect[i];
            arrSelect[i] = temp;
        }

        System.out.println("The Sorted array is: ");
        printArray(arrSelect);


        System.out.println("------------------------------");


        //! INSERTION SORT
        // Take an element from the unsorted array, place it in its corresponding position in the sorted part, and shift the elements accordingly. 
        // Time Complexity: O(N^2) 


        System.out.println("Enter the size for your array: ");
        int sizee = sc.nextInt();
        System.out.println("Enter your array: ");
        int [] arrInsert = new int[sizee];

        //Input the array
        for(int i = 0; i < arrInsert.length; i++) {
            arrInsert[i] = sc.nextInt();
        }

        //Output the array entered
        System.out.println("You entered: ");
        for(int k = 0; k<arrInsert.length; k++) {
            System.out.print(arrInsert[k] + " ");
        }
        System.out.println();


        //Sorting Mechanism

        for(int i = 1; i < arrInsert.length; i++) {

            int current = arrInsert[i];
            int j = i-1;
            while(j >= 0 && current < arrInsert[j]) {
                // keep swapping
                arrInsert[j+1] = arrInsert[j];
                j--;
            }
            arrInsert[j+1] = current;
        }
        printArray(arrInsert);

        sc.close();
    }
}
