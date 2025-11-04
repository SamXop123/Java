package DSA.Sorting;

/*
notes:
selection sort works by selecting the smallest element from the unsorted part
of the array and swapping it with the element at the current position. 
the outer loop fixes one position at a time and the inner loop finds
the smallest element from the rest of the array. 
this keeps repeating until the whole array is sorted. 
time complexity is O(n^2) since we check every pair, 
but it uses no extra space.
*/

public class SelectionSort {
    public static void main(String[] args) {

        int[] arrSelect = {1,8,2,9,5,6,1,7};

        for (int i = 0; i < arrSelect.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arrSelect.length; j++) {
                if (arrSelect[smallest] > arrSelect[j]) {
                    smallest = j;
                }
            }

            int temp = arrSelect[smallest];
            arrSelect[smallest] = arrSelect[i];
            arrSelect[i] = temp;
        }

        System.out.println("Sorted array:");
        for (int val : arrSelect) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
