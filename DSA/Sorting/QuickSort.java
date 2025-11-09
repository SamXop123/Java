package DSA.Sorting;

/*
notes:
quick sort uses divide and conquer like merge sort but works differently. 
it picks a pivot (here the first element) and arranges elements so that smaller ones are on left and bigger ones on right. 
mainAlgo() does this partitioning part and returns the final position of the pivot. then quickAlgo() recursively sorts the left and right halves. 
it’s fast on average with O(n log n) time but can go worst case O(n^2) if pivot choice is bad. still it’s one of the most efficient sorts in practice.
*/

public class QuickSort {

    public void quickAlgo(int[] nums, int low, int high) {
        if(low < high) {
            int pivotIdx = mainAlgo(nums, low, high);
            quickAlgo(nums, low, pivotIdx-1);
            quickAlgo(nums, pivotIdx+1, high);
        }
    }

    public int mainAlgo(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while(i < j) {
            while(nums[i] <= pivot && i <= high-1) {
                i++;
            }
            while(nums[j] > pivot && j >= low+1) {
                j--;
            }

            if(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;

        return j;
    }

    public int[] quickSort(int[] nums) {
        quickAlgo(nums, 0, nums.length-1);
        return nums;
    }    
}
