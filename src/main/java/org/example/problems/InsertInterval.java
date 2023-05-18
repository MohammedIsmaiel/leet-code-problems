package org.example.problems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                merged.add(interval);
            } else if (interval[0] > newInterval[1]) {
                if (!inserted) {
                    merged.add(new int[] { start, end });
                    inserted = true;
                }
                merged.add(interval);
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        if (!inserted) {
            merged.add(new int[] { start, end });
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}

// if (newInterval[1] >= interval[0] && newInterval[1] <= interval[1]) {
// end = Math.max(interval[1], newInterval[1]);
// }