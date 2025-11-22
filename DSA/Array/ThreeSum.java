package DSA.Array;

import java.util.*;

/*
notes:
this finds all unique triplets that sum to zero. 
first the array is sorted so two pointers can be used easily. 
for each i, pointers j and k move from both ends and adjust based on whether the sum is less or more than zero. 
when a valid triplet is found, it's added and j is moved forward while skipping duplicates. 
i also skips duplicates to avoid repeating answers. 
overall works in O(n^2) time since each element gets paired with a two-pointer sweep.
*/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n-2; i++) {
            
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) j++;
                }
            }
        }

        return list;
    }
}
