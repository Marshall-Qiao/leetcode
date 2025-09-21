class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        // if(intervals == null || intervals.length == 0){
        //    list.add(newInterval); 
        //    return list.toArray(int[][]::new);
        // } 
        // if(intervals[0][0] > newInterval[1]){
        //     list.add(newInterval); 
        //     for(int j = 0;j<intervals.length;j++)list.add(intervals[j]); 
        //     return list.toArray(int[][]::new);
        // }
        //  if(intervals[intervals.length-1][1] < newInterval[0]){
        //     for(int j = 0;j<intervals.length;j++)list.add(intervals[j]); 
        //     list.add(newInterval); 
        //     return list.toArray(int[][]::new);
        // }

        int i = 0;
        while(i< intervals.length && intervals[i][1] < newInterval[0]){
             list.add(intervals[i]);
             i++;
        }
        while(i< intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);


        while(i< intervals.length ){
            list.add(intervals[i]);
             i++;
        }
        return list.toArray(int[][]::new);
    }
}