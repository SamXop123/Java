package DSA.Array;
import java.util.*;

//! Program to generate the Nth row of Pascal's Triangle

/*
notes:
this generates the nth row of pascal’s triangle without building the whole triangle. 
the first value is always 1, and each next value is calculated using the relation 
C(n, k) = C(n, k-1) * (n-k) / k 
which avoids factorials. 
the loop keeps updating the value and adds it to the list, 
so the whole row is built in O(n) time with no extra space.
*/

public class nthRowPascalsTriangle {
    public List<Long> getNthRow(int N) {
        List<Long> row = new ArrayList<>();
        
        long val = 1;
        row.add(val);
        
        // Compute remaining values using the relation:
        // C(n, k) = C(n, k-1) * (n-k) / k
        for (int k = 1; k < N; k++) {
            val = val * (N - k) / k;
            row.add(val);
        }
        
        return row;
    }
}

