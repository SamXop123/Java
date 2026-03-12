package DSA.Math;

/*
notes:

this implements the chinese remainder theorem to solve a system of congruences like:
    x ≡ a1 (mod m1)
    x ≡ a2 (mod m2)
    x ≡ a3 (mod m3)
where all mod values m[i] are pairwise coprime.

first the product of all mod values is computed:
    M = m1 * m2 * ... * mn

for each equation:
    Mi = M / m[i]
Mi represents the product of all mod values except m[i].

then we find y such that:
    (Mi * y) % m[i] = 1
this y is the modular inverse of Mi with respect to m[i].

each equation contributes:
    a[i] * Mi * y
to the final solution.

all contributions are added together and finally taken mod M:
    X = (Σ a[i] * Mi * inverse(Mi)) % M

this gives the smallest number X that satisfies all the congruences simultaneously.

example in this code:
    x ≡ 1 (mod 2)
    x ≡ 1 (mod 5)
    x ≡ 4 (mod 7)

the program calculates the smallest x that satisfies all three equations.
*/

public class ChineseRemainderTheorem {

    public static void main(String[] args) {
        int a[] = {1,1,4};
        int m[] = {2,5,7};
        int n = m.length;
        int M = 1;

        for(int i = 0; i < n; i++) M *= m[i];

        int ans = CRT(a, m, n, M);

        System.out.println(ans);
    }

    static int CRT(int a[], int m[], int n, int M) {
        int X = 0;

        for(int i = 0; i < n; i++) {
            int Mi = M / m[i];
            int y = 0;

            for(int j = 1; j < m[i]; j++) {
                if((Mi * j) % m[i] == 1) {
                    y = j;
                    break;
                }
            }

            X += a[i] * Mi * y;
        }

        return X % M;
    }
}

