class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1) return points.length;
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int ans = 0, arrow = 0;
        for (int i = 0; i < points.length; i++) {
            if (ans == 0 || points[i][0] > arrow){
                ans++;
                arrow = points[i][1];
            }
        }
        return ans;
    }
}