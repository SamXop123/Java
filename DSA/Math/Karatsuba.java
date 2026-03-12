package DSA.Math;

/*
notes:

this implements karatsuba multiplication which multiplies large numbers faster than the normal grade-school method.
instead of doing 4 multiplications when splitting numbers, 
it reduces it to only 3 recursive multiplications.

the numbers x and y are split into two halves:
    x = a * 10^m + b
    y = c * 10^m + d

normal multiplication would be:
    ac * 10^(2m) + (ad + bc) * 10^m + bd

karatsuba avoids computing ad and bc separately by using this trick:
    (a+b)(c+d) = ac + ad + bc + bd

so if we already know:
    z2 = ac
    z0 = bd
    z1 = (a+b)(c+d)

then:
    ad + bc = z1 - z2 - z0

so final result becomes:
    z2 * 10^(2m) + (z1 - z2 - z0) * 10^m + z0

the recursion continues until numbers become single digits, where normal multiplication is used.

time complexity:
normal multiplication → O(n²)
karatsuba → O(n^log2(3)) ≈ O(n^1.58)

so this is much faster for very large integers.
*/

public class Karatsuba {
    static long karatsuba(long x, long y) {

        if(x < 10 || y < 10)
            return x*y;

        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());

        int m = n/2;

        long pow = (long)Math.pow(10, m);

        long a = x / pow;
        long b = x % pow;
        long c = y / pow;
        long d = y % pow;

        long z0 = karatsuba(b, d);
        long z1 = karatsuba(a+b, c+d);
        long z2 = karatsuba(a, c);

        return (z2 * (long)Math.pow(10, 2*m)) + ((z1-z2-z0) * pow) + z0;
    }

    public static void main(String[] args) {
        long x = 1234;
        long y = 5678;

        System.out.println(karatsuba(x, y));
    }
}