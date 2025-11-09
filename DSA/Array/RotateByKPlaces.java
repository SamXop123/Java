package DSA.Array;

/*
notes:
this rotates the array by k positions (towards the left). 
basically, each element moves to a new index given by (i - k + n) % n, which wraps around when it goes negative. 
a temp array is used to store the rearranged elements and then copied back to the original array. 
the modulo helps handle k values bigger than the array size. 
time complexity is O(n) and space is O(n) because of the extra array.
*/

public class RotateByKPlaces {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {
            temp[(i-k+n) % n] = nums[i];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
