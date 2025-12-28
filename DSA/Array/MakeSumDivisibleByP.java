package DSA.Array;

/*
notes:
this finds the smallest subarray that needs to be removed so that the remaining sum is divisible by p. 
first the total sum mod p is taken as target, which is how much extra needs to be removed. 
while going through the array, prefix sum mod p is tracked in a hashmap. 
for each index, it checks if there was an earlier prefix such that removing the subarray between them fixes the remainder. 
the smallest such length is kept. if no valid subarray exists, return -1.
*/

class Solution {
    public int MakeSumDivisibleByP(int[] nums, int p) {
        int n = nums.length;

        long totalSum = 0;
        for (int num : nums) totalSum += num;
        int target = (int)(totalSum % p);
        if (target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int minLength = n;
        for(int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;

            int want = (prefix-target+p) % p;

            if(map.containsKey(want)) {
                int dist = i - map.get(want);
                minLength = Math.min(minLength, dist);
            }

            map.put(prefix, i);
        }

        if(minLength >= n) {
            return -1;
        } else {
            return minLength;
        }
    }
}
