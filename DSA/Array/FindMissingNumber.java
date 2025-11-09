package DSA.Array;

/*
notes:
this finds the missing number in an array containing numbers from 0 to n. 
the idea is to calculate the total sum of first n natural numbers using n*(n+1)/2 
and then subtract the actual sum of array elements from it. 
the difference gives the missing number directly. time complexity is O(n) 
since we loop once, and space is O(1).
*/

public class FindMissingNumber {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int sum = (N*(N+1))/2;

        int s2 = 0;
        for (int i = 0; i < N; i++) {
            s2 += nums[i];
        }

        int missingNum = sum - s2;
        return missingNum;       
    }
}
