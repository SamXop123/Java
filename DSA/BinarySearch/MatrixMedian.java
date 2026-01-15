package DSA.BinarySearch;


/*
notes:

this finds the median of a row-wise sorted matrix using binary search on the value range instead of indices. 
low is set to the smallest first element and high to the largest last element across all rows. 
for a guessed value mid, it counts how many elements in the matrix are <= mid by doing binary search on each row. 
if that count is less than the required middle position, mid is too small so move right, otherwise move left. 
in the end low ends up pointing to the median value. 
this avoids flattening the matrix and works in O(n * log(m) * log(range)).
*/

public class MatrixMedian {
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // finding the range.
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int row = 0; row < n; row++) {
            low = Math.min(low, matrix[row][0]);
            high = Math.max(high, matrix[row][m-1]);
        }

        int targetCount = (n*m + 1)/2;
        
        while(low <= high) {
            int mid = (low+high)/2;

            int count = 0;
            for(int i = 0; i < n; i++) {
                int l = 0, r = m-1;
                while (l <= r) {
                    int mid2 = (l + r)/2;
                    if (matrix[i][mid2] <= mid) l = mid2+1;
                    else r = mid2-1;
                }
                count += l;
            }

            if(count < targetCount) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return low;
    }
}
