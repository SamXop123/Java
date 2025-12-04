package DSA.Math;

public class FindMissingAndRepeatingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        long n = nums.length;
        
        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;
        
        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
        
        // Calculate actual sum (S) and sum of squares (S2) of array elements
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }
        
        // Compute the difference values
        long val1 = S - SN; // X - Y
        
        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;
        
        // Calculate X + Y
        val2 = val2 / val1;
        
        // Calculate X and Y
        long x = (val1 + val2) / 2; // repeating
        long y = x - val1;          // missing

        return new int[]{(int) x, (int) y};
    }
}


/*
notes:

Lets say X repeats and Y is missing

Sn = 1 + 2 + ... + N
S = 1, 2, 3, …, X, …, X, …   (X repeats and without Y)

Sn = (sum of all correct numbers)
S = (all correct numbers) - Y + X

Therefore,
S = Sn - Y + X
S − Sn = X − Y  {Equation-1}

---------------
Now,

S2 - S2n = X² - Y²     {Equation-2}

We know,
X² - Y² = (X - Y)(X + Y)

So,
S2 - S2n = (X - Y)(X + Y)

X + Y = (S2 - S2n) / (X - Y)      {Equation-3}

X - Y = D
X + Y = E     (E = that quotient from eq-3)

Two equations, two unknowns.
Solve them,
X = ( (X - Y) + (X + Y) ) / 2  = (D + E) / 2
Y = X - D

and BOOM we got our answer!
*/

