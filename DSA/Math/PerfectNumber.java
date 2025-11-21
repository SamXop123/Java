package DSA.Math;

/*
notes:
a perfect number is a number whose proper divisors add up exactly to the number itself. 
examples are 6 (1+2+3) and 28 (1+2+4+7+14). 
the code checks divisors up to sqrt(n) and adds both i and n/i when dividing cleanly. 
sum starts from 1 because 1 is always a divisor. 
finally return true if the total matches n. 
this avoids checking all numbers till n and runs in O(sqrt(n)).
*/

public class PerfectNumber {
    public static boolean isPerfect(int n) {
        if (n <= 1) return false;

        int sum = 1; 
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(isPerfect(6));  // true
        System.out.println(isPerfect(28)); // true
        System.out.println(isPerfect(10)); // false
    }
}
