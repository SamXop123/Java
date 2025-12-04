package DSA.Array;

/*
notes:
this finds one repeating number and one missing number in an array containing values from 1 to n. 
a boolean array is used to mark which numbers have appeared. 
if a number is already marked and appears again, that becomes the repeating one. 
after marking everything, a second loop checks which number from 1 to n never got marked - that’s the missing one. 
simple O(n) time and O(n) space approach using frequency marking.
*/

public class FindRepeatingAndMissingNum {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        boolean[] arr = new boolean[n+1];

        int A = 0;
        int B = 0;

        for(int i = 0; i < n; i++) {
            if(arr[nums[i]]) {
                A = nums[i];
            } else {
                arr[nums[i]] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            if(!arr[i]) {
                B = i;
                break;
            }
        }

        return new int[]{A, B};
    }
}

