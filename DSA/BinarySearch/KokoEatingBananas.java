package DSA.BinarySearch;

/*
notes:
this uses binary search to find the minimum eating speed k such that koko can finish all piles within h hours. 
for a guessed speed mid, the total hours needed is calculated by summing how many hours each pile takes.

the formula (piles[i] + mid - 1) / mid is used to do ceiling division in integers. 
it means “how many full hours are needed to eat piles[i] bananas if mid bananas are eaten per hour”. 
for example, if piles[i] = 7 and mid = 3, normal division gives 2 but actually 3 hours are needed, and (7 + 3 - 1) / 3 = 3 correctly handles that. 
this avoids using floating point math and gives the correct rounded-up value.

if the total hours is <= h, this speed is valid so search moves left to try a smaller speed. otherwise, speed is too slow so move right.
*/

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for(int pile : piles) max = Math.max(max, pile);

        int low = 1; 
        int high = max;
        int ans = max;

        while(high >= low) {
            int mid = low + (high-low)/2;

            long hours = 0; 
            for(int i = 0; i < piles.length; i++) {
                hours += (piles[i]+mid-1)/mid;
            }

            if(hours <= h) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
