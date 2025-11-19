package DSA.Array;
import java.util.ArrayList;
import java.util.List;

/*
notes:
this goes through the matrix in spiral order by using four boundaries: 
left, right, top, bottom. 
each loop prints the top row, then right column, then bottom row, then left column, 
and after each step the boundaries shrink towards the center. 
the while condition makes sure we don’t cross boundaries. 
overall it just keeps peeling the matrix layer by layer in a spiral.
*/

public class SpiralOrderMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiral = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
        while(top <= bottom && left <= right) {
            
            for (int col = left; col <= right; col++) {
                spiral.add(matrix[top][col]);
            }
            top++;

            for(int row = top; row <= bottom; row++) {
                spiral.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    spiral.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    spiral.add(matrix[row][left]);
                }
                left++;
            }
        }

        return spiral;
    }
}
