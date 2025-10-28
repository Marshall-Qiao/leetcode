class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int n = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int provice = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            provice++;
            q.offer(i);
            visited.add(i);

            while (!q.isEmpty()) {
                int[] one = isConnected[q.poll()];
                for (int idx = 0; idx < n; idx++) {
                    if (visited.contains(idx) || 0 == one[idx]) continue;
                    visited.add(idx);
                    q.offer(idx);
                }
            }
        }
        return provice;
    }
}