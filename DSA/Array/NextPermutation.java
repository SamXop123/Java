package DSA.Array;

/*
notes:
this finds the next permutation of the array in lexicographic order. 
first a point is found (idx) where nums[i] < nums[i+1], which means a change can be made. 
if no such index exists, the array is already the highest permutation so it gets reversed to the lowest one. 
otherwise, swap nums[idx] with the next bigger element from the right side, 
and then reverse the part after idx to make it the smallest possible. 
this gives the immediate next permutation.

understand with the following example:
[2 3 5 4 1 0 0]
*/

// =======================================================

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // we are finding the position where the array stops decreasing when we look from right to left.
        int idx = -1;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        // After this part "idx = 1" -> (nums[idx]=3)


        // if no such index found (edge case), then we can simply reverse the array and it will be the answer 
        if(idx == -1) {
            int rev[] = new int[n];
            for(int i = 0; i < n; i++) {
                rev[i] = nums[n-i-1];
            }

            for(int i = 0; i < n; i++) {
                nums[i] = rev[i];
            }
            return;
        }


        // find the number just greater than nums[idx] so that we can swap it because it will be the foundation of our next permutation. 
        // we can do this by iterating from right to left and as we find a bigger number then we can swap it with nums[idx[
        for(int i = n-1; i > idx; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        // After this part resulting nums will be [2 1 5 4 3 0 0]


        // and now finally we can reverse the part after nums[idx] so to get the next permutation, 
        // as we need the next permutation so this part need to be the smallest. so we can do this by reversing.
        int rev[] = new int[n-idx-1];
        int pointer = 0;
        for(int i = n-1; i > idx; i--) {
            rev[pointer++] = nums[i];
        }

        pointer = 0;
        for(int i = idx+1; i < n; i++) {
            nums[i] = rev[pointer++];
        }

        // final nums array - > [2 1 0 0 3 4 5]

    }
}
