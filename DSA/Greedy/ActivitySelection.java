package DSA.Greedy;

import java.util.*;

  /*
    notes:

      activity selection problem:
        we are given multiple activities, and each activity has:
        1) start time
        2) finish time

        goal:
        select the maximum number of activities such that
        no two selected activities overlap.

        greedy idea:
        always choose the activity that finishes earliest.
        why?
        because it leaves the maximum time available for the remaining activities.

        approach:
        1) store all activities in a 2D array as [start, finish]
        2) sort them according to finish time
        3) always select the first activity
        4) then for every next activity:
           if its start time >= finish time of last selected activity,
           then select it

        time complexity:
        sorting = O(n log n)
        traversal = O(n)
        total = O(n log n)
    */

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {5, 1, 3, 0, 5, 8};
        int[] finish = {9, 2, 4, 6, 7, 9};

        int n = start.length;
      
        // storing each activity as [start, finish]
        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        // sort activities on the basis of finish time
        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        System.out.println("Selected activities are:");
        System.out.println(activities[0][0] + " " + activities[0][1]); // first activity
      
        int lastFinish = activities[0][1];

        // check remaining activities
        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastFinish) {
                System.out.println(activities[i][0] + " " + activities[i][1]);
                lastFinish = activities[i][1];
            }
        }
    }
}
