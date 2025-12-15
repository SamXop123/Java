package DSA.BinarySearch;

/*
notes:

this searches a target in a rotated sorted array using modified binary search. 
at every step, one half of the array is always sorted. first check which half is sorted using nums[low] <= nums[mid]. 
if the target lies inside the sorted half, move the search there, otherwise search the other half. 
this keeps reducing the search space and gives O(log n) time complexity.

but when the array also contains duplicates, we need to check a special edge case as well.
normally one half of the array is always sorted, but when nums[low], nums[mid], and nums[high] are equal, it becomes impossible to tell which side is sorted.
in that case, low is increased and high is decreased to shrink the search space safely. 
because of duplicates, worst case time complexity can degrade to O(n), but average case is still close to O(log n).
*/


public class SearchInRotatedSortedArray {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = (low+high)/2;


            if(nums[mid] == target) {
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return false;
    }
}
