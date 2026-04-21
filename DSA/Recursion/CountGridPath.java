package DSA.Recursion;

// Manuevering - Grid Path Counting Problem using Recursion

public class GridPaths {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("No. of ways are: " + path(0, 0, n));
    }

    static int path(int i, int j, int n) {

        // reached destination
        if(i == n-1 && j == n-1) return 1;

        // out of bounds
        if(i >= n || j >= n) return 0;

        // at each cell we have two options either down or right, so that is why we add both.
        return path(i+1, j, n) + path(i, j+1, n);
    }
}
