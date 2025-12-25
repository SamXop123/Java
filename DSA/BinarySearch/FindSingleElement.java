package DSA.BinarySearch;

/*
notes:
this finds the single element in a sorted array where every other element appears twice. 
binary search is used by checking whether mid matches with the next or previous element. 
based on where the pairing breaks and whether the remaining side has odd length, the search moves left or right. 
when mid doesn’t match either neighbor, that value itself is the answer. 
*/

public class FindSingleElement {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];
        
        while (low <= high) {
            int mid = low + (high-low)/2;

            boolean matchesNext = (mid < n-1) && (nums[mid] == nums[mid+1]);
            boolean matchesPrev = (mid > 0) && (nums[mid] == nums[mid-1]);

            if (matchesNext) {
                if ((high-mid-1)%2 != 0) {
                    low = mid+2;
                } else {
                    high = mid-1;
                }
            } else if (matchesPrev) {
                if ((high-mid)%2 != 0) {
                    low = mid+1;
                } else {
                    high = mid-2;
                }
            } else {
                return nums[mid];
            }
        }

        return -1;
    }
}
