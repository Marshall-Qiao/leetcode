class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // 按区间终点升序


       int pre = 0;
       int count = 1;
       for (int i = 1; i < intervals.length ; i++) {
           if(intervals[i][0] >= intervals[pre][1]) {
              pre = i;
              count++;
           }
       }
       return  intervals.length - count;
    }
}