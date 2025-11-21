package DSA.Array;

//! (Sort 0s, 1s, 2s)


/*
notes:
this sorts an array of 0s, 1s, and 2s using three pointers: low for 0s, mid for 1s, and high for 2s. 
mid moves through the array and based on the value, either swaps with low for 0s, moves ahead for 1s, or swaps with high for 2s. 
the idea is to group all 0s to the left, 1s in the middle, and 2s at the end in one pass. 
overall it works in O(n) time and O(1) space.
*/


public class DutchNationalFlagAlgorithm {

    public static void sortColors(int[] arr) {
        int low = 0;      // pointer for 0s
        int mid = 0;      // pointer for 1s
        int high = arr.length - 1; // pointer for 2s

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                
                low++;
                mid++;
            } 
            else if (arr[mid] == 1) {
                mid++; // correct position, just move forward
            } 
            else { 
                // arr[mid] == 2
                // swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--; // do NOT increment mid here
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};

        sortColors(arr);

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
