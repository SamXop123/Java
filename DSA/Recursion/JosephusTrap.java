package DSA.Recursion;

/*
notes:

imagine a group of people standing in a circle.
they’re numbered from 1 to n.

# now a rule begins:
  1. start from person 1.
  2. count around the circle.
  3. every k-th person gets eliminated.
  4. after elimination, counting continues from the next person.
  5. repeat until only one person survives.

that survivor is the answer.
this is the josephus trap problem.

*/

public class Josephus {
    public static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(josephus(n, k) + 1); // +1 for 1-based index
    }
}
