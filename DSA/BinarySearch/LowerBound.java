package DSA.BinarySearch;

/*
notes:
this finds the lower bound of a target which is basically the first index where arr[i] >= target. 
binary search checks mid, and if arr[mid] meets the condition, ans is updated and search continues on the left side. 
if arr[mid] is smaller, move right. if no element is >= target, ans stays equal to n.
*/

public class LowerBound {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,5,7,9,13};
        int n = arr.length;
        int target = 8;

        int low = 0;
        int high = n - 1;
        int ans = n;

        while(low <= high) {
            int mid = (low+high)/2;

            if(arr[mid] >= target) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
