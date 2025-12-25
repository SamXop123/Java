package DSA.BinarySearch;

/*
notes:

this uses binary search on the answer to find the maximum minimum distance between k cows. 
first the stall positions are sorted, then a distance mid is guessed. 
for a given mid, cows are placed greedily starting from the first stall, and a new cow is placed whenever the distance from the last one is at least mid. 
if at least k cows can be placed, mid is a valid distance so try a bigger one, otherwise try smaller. 
final ans stores the largest distance that worked.
*/


import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int low = 1;
        int high = nums[n-1] - nums[0];
        int ans = 0;

        while(low <= high) {
            int mid = low + (high-low)/2;

            int count = 1;
            int last = nums[0];
            for(int i = 1; i < n; i++) {
                if(nums[i]-last >= mid) {
                    count++;
                    last = nums[i];
                }
            }

            if(count >= k) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }
}
