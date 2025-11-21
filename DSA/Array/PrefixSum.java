package DSA.Array;

/*
notes:
this builds a prefix sum array where each index stores the sum from the start up to that point. 
once the prefix array is ready, any range sum L to R can be answered in O(1) by subtracting prefix[L-1] from prefix[R]. 
it avoids looping through the same elements again and again, so it's great for multiple range sum queries.
*/

public class PrefixSum {
    
    // Function to build prefix sum array
    public static int[] buildPrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];

        prefix[0] = arr[0]; // first element stays same

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    // Function to get sum of range L to R using prefix sum (0-indexed)
    public static int rangeSum(int[] prefix, int L, int R) {
        if (L == 0) {
            return prefix[R];
        }
        return prefix[R] - prefix[L - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 9};

        // Build prefix array
        int[] prefix = buildPrefixSum(arr);

        // Print prefix array
        System.out.print("Prefix Sum Array: ");
        for (int num : prefix) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Sum of range (0 to 2): " + rangeSum(prefix, 0, 2));
        System.out.println("Sum of range (1 to 4): " + rangeSum(prefix, 1, 4));
    }
}
