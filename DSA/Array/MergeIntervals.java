package DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
notes:
this merges overlapping intervals by sorting them based on start time first. 
after sorting, each interval is checked against the last added one...
if they don’t overlap, it’s added as a new interval. 
if they do overlap, the end value is extended to the max of both. 
final list is converted back to a 2D array. overall works in O(n log n) because of sorting.
*/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(
            intervals, 
            (a, b) -> Integer.compare(a[0], b[0])
        );

        List<List<Integer>> res = new ArrayList<>();

        for(int[] arr : intervals) {
            if(res.isEmpty() || res.get(res.size()-1).get(1) < arr[0]) {
                res.add(Arrays.asList(arr[0], arr[1]));
            } else {
                int last = res.size()-1;
                int lastEl = res.get(last).get(1);
                res.get(last).set(1, Math.max(lastEl, arr[1]));
            }
        }

        int[][] merged = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            merged[i][0] = res.get(i).get(0);
            merged[i][1] = res.get(i).get(1);
        }

        return merged;
    }
}

