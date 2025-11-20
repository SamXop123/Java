/*
notes:
this builds pascal’s triangle row by row. the first and last values of every row are always 1, 
and the inside values come by adding two numbers from the previous row. 
each new row looks at result.get(i-1) to compute the middle elements. 
the triangle keeps growing until numRows is reached. 
time complexity is O(n^2) since every row and column is filled once.
*/


package DSA.Array;

import java.util.ArrayList;
import java.util.List;

public class FullPascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1; j < i; j++) {
                List<Integer> prevRow = result.get(i-1);
                int left = prevRow.get(j-1);
                int right = prevRow.get(j);
                int val = left + right; 
                row.add(val);
            }

            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}

