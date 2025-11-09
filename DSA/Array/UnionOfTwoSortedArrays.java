package DSA.Array;

import java.util.ArrayList;
import java.util.List;

/*
notes:
this takes two sorted arrays and finds their union without duplicates. 
two pointers i and j move through both arrays - whichever has the smaller value gets added to the result list first. 
duplicates are avoided by checking the last added element before inserting a new one. 
after one array finishes, the remaining elements of the other are added. final list is then converted to an array. 
overall it’s O(n + m) since both arrays are traversed once.
*/

public class UnionOfTwoSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {

        List<Integer> union = new ArrayList<>();

        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;

        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                if(union.size() == 0 || nums1[i] != union.get(union.size()-1)) {
                    union.add(nums1[i]);
                }
                i++;
            } else {
                if(union.size() == 0 || nums2[j] != union.get(union.size()-1)) {
                    union.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (union.get(union.size()-1) != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }
        while (j < m) {
            if (union.get(union.size()-1) != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }

        int[] arr = new int[union.size()];
        for(int k = 0; k < union.size(); k++) {
            arr[k] = union.get(k);
        }
        
        return arr;
    }
}
