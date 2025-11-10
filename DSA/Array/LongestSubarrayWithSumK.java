package DSA.Array;

/*
notes:
this finds the length of the longest subarray whose sum equals k using a brute force approach. 
two loops are used — the outer loop fixes the starting point and the inner one adds elements until the sum matches k. 
whenever sum == k, the length is updated if it's greater than previous max. 
time complexity is O(n^2) since every subarray is checked, but it’s easy to understand and good for the basic approach.
*/

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}

// --------------------------------------------------------------------
/*

! OTHER METHOD (TWO POINTER APPROACH)

=======================================================================
notes:
this uses the sliding window (two pointer) approach to find the longest subarray with sum k. 
the window expands by moving right and shrinks from left when the sum gets bigger than k. 
whenever sum == k, the length of the current window is checked and maxLen is updated. 
it only works for arrays with non-negative numbers since the sum behavior is predictable. time complexity is O(n) and space is O(1).
=======================================================================


public static int getLongestSubarray(int []a, long k) {

    int n = a.length; // size of the array.
    int left = 0, right = 0; // 2 pointers
    long sum = a[0];
    int maxLen = 0;
    while (right < n) {

        while (left <= right && sum > k) {
            sum -= a[left];
            left++;
        }

        if (sum == k) {
            maxLen = Math.max(maxLen, right - left + 1);
        }

        right++;
        if (right < n) sum += a[right];
    }

    return maxLen;
}
    
*/