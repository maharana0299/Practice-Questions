import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int left = 0;
        int count = 0;

        for (int right = 1; right < intervals.length; right++) {
            if (intervals[left][1] <= intervals[right][0]) {
                // no overlap
                left = right;
            } else if (intervals[left][1] < intervals[right][1]) {
                count++; // overlapping (1,10) (8,12)
            }
            
            else if (intervals[left][1] >= intervals[right][1]) {
                count++;
                left = right; // overlapping (1,10) (4,8)
            }
        }

        return count;
    }
}
