package DSA.Math;

/*
 * notes:
 * this uses binary exponentiation to compute base^exp efficiently.
 * if the current power is odd, multiply result by base.
 * then square the base and cut the exponent in half using right shift.
 * in these type of questions requiring fast exponentiation, we would often be asked to compute the result involving large numbers. so in those cases we would take the %MOD with the values that are being multiplied. and the modulo value would almost certainly be given in all those questions.    
 */

public class FastExponentiationRecursive {

    public static long power(long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = power(base, exp / 2);
        long result = half * half;

        if (exp % 2 == 1) {
            result = result * base;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10)); // Result: 1024
    }
}
