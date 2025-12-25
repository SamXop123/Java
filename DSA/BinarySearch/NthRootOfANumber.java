package DSA.BinarySearch;

/*
notes:

this finds the integer nth root of M using binary search. 
the search space is from 0 to M and mid is tested by multiplying it N times. 
if mid^N equals M, that mid is the answer. if it’s smaller, move right, and if it’s bigger, move left. 
the power is calculated carefully and stopped early if it goes beyond M to avoid overflow. 
returns -1 if no integer nth root exists.

Example 1
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.

Example 2
Input: N = 4, M = 69
Output:-1
Explanation: The 4th root of 69 does not exist. So, the answer is -1.

*/


public class NthRootOfANumber {
    public int NthRoot(int N, int M) {
        
        int low = 0;
        int high = M;

        while(low <= high) {
            int mid = low + (high-low)/2;

            long ans = 1;
            for(int i = 0; i < N; i++) {
                ans *= mid;
                if(ans > M) break;
            }

            if(ans == M) return mid;    
            else if(ans < M) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
