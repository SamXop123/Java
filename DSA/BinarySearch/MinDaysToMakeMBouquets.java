package DSA.BinarySearch;

/*
notes:

this uses binary search on the answer to find the minimum day needed to make m bouquets. 
the idea is to guess a day (mid) and check if it’s possible to form at least m bouquets by that day. 
for a given mid, the array is scanned and a count is kept of how many flowers are bloomed (bloomDay <= mid). when count reaches k, one bouquet is formed and count resets. 
if enough bouquets can be made, mid is a valid answer so search moves left to find a smaller day, otherwise move right. 
if m*k is greater than total flowers, it’s impossible so return -1.
*/

public class MinDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;

        int low = 1;
        int high = (int) 1e9;
        int ans = -1;
        while(high >= low) {
            int mid = low + (high-low)/2;

            int count = 0;
            int bouquet = 0;
            for(int op : bloomDay) {
                if(op <= mid) {
                    count++;
                    if(count == k) {
                        bouquet++;
                        count = 0;
                    }
                } else {
                    count = 0;
                }
            }

            if(bouquet >= m) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }

        }

        return ans;
    }   
}
