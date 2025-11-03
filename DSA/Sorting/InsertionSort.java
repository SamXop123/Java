package DSA.Sorting;

/*
notes:
this is just a simple insertion sort. we start from index 1 and assume the left part is already sorted. 
then we pick the current element and keep moving it to the left until it’s in the right spot by shifting 
bigger elements one step right. 
so basically like inserting a card in the right position in a sorted hand. it’s O(n^2) in worst case 
but works fine for small arrays.
*/

public class InsertionSort {
    public static void main(String[] args) {

        int[] arrInsert = {1,8,2,9,5,6,1,7};

        // Sorting Mechanism
        for (int i = 1; i < arrInsert.length; i++) {
            int current = arrInsert[i];
            int j = i - 1;

            while (j >= 0 && current < arrInsert[j]) {
                arrInsert[j + 1] = arrInsert[j];
                j--;
            }
            arrInsert[j + 1] = current;
        }

        System.out.println("Sorted array:");
        for (int val : arrInsert) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}

