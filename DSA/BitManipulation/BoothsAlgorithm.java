package DSA.BitManipulation;

import java.util.Scanner;

/*
notes:

booth’s algorithm multiplies signed binary numbers efficiently using addition,
subtraction and arithmetic right shifts. instead of adding the multiplicand
for every 1 bit in the multiplier, it looks at pairs of bits (Q0 and Q-1).

rules:
Q0 Q-1 = 10 → subtract M from A
Q0 Q-1 = 01 → add M to A
Q0 Q-1 = 00 or 11 → no operation

register meaning:
A  = accumulator
Q  = multiplier
M  = multiplicand
Q-1 = previous least significant bit of Q

after the operation decision, an arithmetic right shift is performed on
[A Q Q-1]. this keeps the sign bit for negative numbers.

the loop runs for n bits of the multiplier. at the end, the result is
obtained by combining A and Q.

example used here:
multiplicand = -6 (0110 and 1011)
multiplier   = 5
result should be = -30


| Step  | Operation                 | A (Accumulator) | Q (Multiplier) | Q₋₁ |
| ----- | ------------------------- | --------------- | -------------- | --- |
| Start | Initial values            | 00000           | 00101          | 0   |
| 1     | Q0Q-1 = 10 → A = A − M    | 00110           | 00101          | 0   |
| Shift | Arithmetic Right Shift    | 00011           | 00010          | 1   |
| 2     | Q0Q-1 = 01 → A = A + M    | 11101           | 00010          | 1   |
| Shift | Arithmetic Right Shift    | 11110           | 10001          | 0   |
| 3     | Q0Q-1 = 10 → A = A − M    | 00100           | 10001          | 0   |
| Shift | Arithmetic Right Shift    | 00010           | 01000          | 1   |
| 4     | Q0Q-1 = 01 → A = A + M    | 11100           | 01000          | 1   |
| Shift | Arithmetic Right Shift    | 11110           | 00100          | 0   |
| 5     | Q0Q-1 = 00 → No operation | 11110           | 00100          | 0   |
| Shift | Arithmetic Right Shift    | 11111           | 00010          | 0   |


*/


public class BoothsAlgorithm {

    static int multiply(int m, int r) {
        int A = 0;
        int Q = r;
        int M = m;
        int Q_1 = 0;

        int n = 4;   // number of bits (can adjust)

        for (int i = 0; i < n; i++) {
            int Q0 = Q & 1;

            if (Q0 == 1 && Q_1 == 0) {
                A = A - M;
            }
            else if (Q0 == 0 && Q_1 == 1) {
                A = A + M;
            }

            // arithmetic right shift
            Q_1 = Q & 1;
            Q = (Q >> 1) | ((A & 1) << (n - 1));
            A = A >> 1;
        }

        return (A << n) | Q;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter multiplicand: ");
        int m = sc.nextInt();

        System.out.print("Enter multiplier: ");
        int r = sc.nextInt();

        int result = multiply(m, r);

        System.out.println("Result = " + result);
        sc.close();
    }
}
