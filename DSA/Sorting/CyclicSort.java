package DSA.Sorting;

/*
notes:
this sorts an array that contains numbers from 1 to n using cyclic sort. 
each number is supposed to be at index (value - 1), so the loop keeps swapping nums[i] with its correct index until it reaches the right spot. 
i only moves forward when the current element is already in its correct position. 
this way the whole array gets sorted in O(n) time without using any extra space.
*/

public class CyclicSort {
    public void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }

}
