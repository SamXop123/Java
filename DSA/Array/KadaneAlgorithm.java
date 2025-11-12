package DSA.Array;

/*
notes:
kadane’s algorithm finds the maximum subarray sum in O(n) time. 
the idea is to keep adding elements to the current sum, and if sum becomes negative, 
reset it to 0 because a negative sum won’t help in forming a larger subarray. 
max keeps track of the best sum seen so far. 
simple but super efficient for max subarray problems.

the only part it breaks is when the array has all the elements as negative, 
becuase then we have to initialize the sum variable with the first element from 
the array i.e. nums[0].
*/

public class KadaneAlgorithm {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if(sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
