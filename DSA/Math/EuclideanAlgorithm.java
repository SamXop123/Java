package DSA.Math;

/*
notes:
this finds gcd using the euclidean algorithm where gcd(a, b) is same as gcd(b, a % b). 
the recursion keeps reducing the pair until b becomes 0, and whatever is left in a is the gcd. 
it’s very fast because each step cuts down the numbers significantly. 
iterative version works the same but uses a while loop.
*/

public class EuclideanAlgorithm {
    // Recursive version
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 56;
        int b = 98;

        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
    }
}


/* 

Iterative version (sometimes used in competitive programming):

```
public static int gcdIterative(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
```
*/
