package DSA.Array;


/*
notes:
this uses the moore’s voting algorithm to find the element that appears more than n/2 times. 
the idea is to keep a count and a candidate number. when count is 0, the current element becomes the new candidate. 
if the element matches the candidate, count increases, otherwise decreases. 
the remaining candidate at the end is the majority element. time complexity O(n), space O(1).
*/


public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for(int i = 0; i <= nums.length-1; i++) {
            if(count == 0) {
                num = nums[i];
            }
 
            if(nums[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
