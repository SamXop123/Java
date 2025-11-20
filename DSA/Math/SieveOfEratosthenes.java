package DSA.Math;

import java.util.Arrays;

/*
notes:
this uses the sieve technique to mark all prime numbers up to n. 
at first all numbers are assumed prime, then multiples of each number starting from i*i are marked false. 
prime[0] and prime[1] are set false manually because they aren’t primes. 
by the end, any index with true is a prime number. 
the sieve runs in O(n log log n) time, which makes it way faster than checking each number one by one.
*/

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100; // find primes up to n
        boolean[] isPrime = sieve(n);

        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}
