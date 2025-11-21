package DSA.Math;

/*
notes:
this uses binary exponentiation to compute base^exp efficiently. 
if the current power is odd, multiply result by base. 
then square the base and cut the exponent in half using right shift. 
this reduces the work from O(exp) to O(log exp), which is much faster for large powers.
*/

public class FastPowerFunction {
    public static long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) { // odd power
                result *= base;
            }
            base *= base;
            exp >>= 1; // divide by 2
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10)); // 1024
    }
}