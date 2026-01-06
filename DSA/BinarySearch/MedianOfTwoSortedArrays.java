package DSA.BinarySearch;

//! TOOOO GOOOOOD QUESTION

/*
notes (written by me):

this finds the median of two sorted arrays in O(log(min(n1,n2))) using binary search on the smaller array. 
instead of merging arrays, it partitions both arrays such that the left half contains exactly half of the total elements 
and all elements on the left are <= all elements on the right.

mid1 is how many elements we take from nums1 for the left half. 
mid2 is automatically decided so that
mid1 + mid2 = (n1 + n2 + 1) / 2. 
this keeps left side always holding the correct number of elements.

l1 and l2 are the last elements of the left part of nums1 and nums2 respectively.
r1 and r2 are the first elements of the right part of nums1 and nums2 respectively.
the correct partition happens when:
    l1 <= r2 AND l2 <= r1
meaning everything on the left is smaller than everything on the right.

once that condition is satisfied:
-> if total length is even, median = (max(l1,l2) + min(r1,r2)) / 2
-> if odd, median = max(l1,l2) becuz left side has one extra element.

if l1 > r2, it means tooo many elements were taken from nums1, so move left.
if l2 > r1, not enough taken from nums1, so move right.

dry run:
nums1 = [1, 3]
nums2 = [2, 4]
total = 4 → even

low = 0, high = 2
mid1 = 1 → nums1 left = [1]
mid2 = (2+2+1)/2 - 1 = 2 - 1 = 1 → nums2 left = [2]

l1 = 1, r1 = 3
l2 = 2, r2 = 4

check:
l1 <= r2 → 1 <= 4 ✓
l2 <= r1 → 2 <= 3 ✓

so partition is correct
median = (max(1,2) + min(3,4)) / 2 = (2 + 3) / 2 = 2.5

andd with this we get the final answer.
*/


public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Crazy way to find the smaller array :o
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while(low <= high) {
            int mid1 = (low+high)/2;
            int mid2 = (n1+n2+1)/2 - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];


            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
            else if(l1 > r2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }

        return 0;
    }
}
