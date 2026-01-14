package DSA.BinarySearch;

// This question also crazy. Nice trick!!

/*
notes:

this finds a peak in a 2d grid using binary search on columns. 
for a chosen column mid, the maximum element in that column is found first. 
then that element is compared with its left and right neighbors to see if it is a peak. 
if it’s bigger than both, that position is returned. 
if the left neighbor is bigger, the peak must be on the left side so high is moved left. 
otherwise it moves right. 
this way the search space is reduced column by column and runs in O(n log m).
*/

public class FindPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;
        while(low <= high) {
            int mid = (high+low)/2;

            int idx = -1;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                if(max < mat[i][mid]) {
                    max = mat[i][mid];
                    idx = i;
                }
            }
            
            int left = -1;
            int right = -1;
            if(mid-1 >= 0) left = mat[idx][mid-1];
            if(mid+1 < m) right = mat[idx][mid+1];

            if(mat[idx][mid] > left && mat[idx][mid] > right) {
                return new int[]{idx, mid};
            } else if (mat[idx][mid] < left) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return new int[]{-1, -1};
    }
}
