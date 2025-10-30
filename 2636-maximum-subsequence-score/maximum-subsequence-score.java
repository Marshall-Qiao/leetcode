class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] effDesc = new int[nums1.length][2];
        for (int i = 0; i < effDesc.length; i++) {
            effDesc[i][0] = nums2[i];
            effDesc[i][1] = nums1[i];
        }
        Arrays.sort(effDesc, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0, res = 0;
        for (int[] curr : effDesc) {
            q.offer(curr[1]);
            sum += curr[1];
            if (q.size() > k) {
                sum -= q.poll();
            }
            if (q.size() == k)
            res = Math.max(res, sum * curr[0]);
        }
        return res;
    }
}