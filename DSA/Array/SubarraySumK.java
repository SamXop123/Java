package DSA.Array;

import java.util.*;

/*
notes:
this counts how many subarrays sum to k using prefix sums and a hashmap. 
prefixSum stores the running total, and if prefixSum - k has been seen before, it means a valid subarray ending at the current index exists. 
the map keeps track of how many times each prefix sum appeared, so count is updated accordingly. 
overall runs in O(n) time since each element is processed once.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];
            int diff = prefixSum-k;

            if(map.containsKey(diff)) {
                count += map.get(diff);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
