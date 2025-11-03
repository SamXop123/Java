package Java.DSA.Sorting;

/*
notes:
so this is the merge sort algo. 
basically we are dividing the array into halves again and again using recursion until only one element is left. 
then we start merging those halves in sorted order. 
in backSorting() we just merge two sorted halves using a temp array and then copy it back to the main array. 
mergeAlgo() handles the recursion part (divide step). so overall we are doing divide and conquer. 
time complexity is n log n since we are dividing log n times and merging takes n time each level. 
space is O(n) bcoz of that temp array.
*/

public class MergeSort {

    public static void backSorting(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int x = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[x++] = arr[left++];
            } else {
                temp[x++] = arr[right++];
            }
        }

        while(left <= mid) {
            temp[x++] = arr[left++];
        }
        while(right <= high) {
            temp[x++] = arr[right++];
        }

        for(int i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }
    }

    public static void mergeAlgo(int[] arr, int low, int high) {
        if(low >= high) return;

        int mid = (low+high)/2;
        mergeAlgo(arr, low, mid);
        mergeAlgo(arr, mid+1, high);
        backSorting(arr, low, mid, high);
    }


    public static void main(String[] args) {
        int arr[] = {6, 3, 8, 5, 2, 9};
        mergeAlgo(arr, 0, arr.length-1);

        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
