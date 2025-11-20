package DSA.Math;

/*
notes:
this calculates nCr using the efficient formula instead of factorials, 
so there’s no overflow from huge numbers. 
only the smaller value of r is used because nCr == nC(n-r), which saves extra steps. 
the loop builds the result by multiplying the next numerator term and dividing by the current i, 
so the value stays manageable and accurate. 
overall it calculates nCr in O(r) time.

9C5 = 9x8x7x6x5 x (9-5)! / 5! x (9-5)! = 9x8x7x6 / 4x3x2x1

*/

public class nCr {
    public long calc_nCr(int n, int r) {

        if (r > n) return 0;

        // Use the smaller r
        if (r > n - r) r = n - r;

        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (n-i+1) / i;
        }

        return result;
    }
}
