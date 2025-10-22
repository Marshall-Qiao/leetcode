class Solution {
    public int longestOnes(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int max = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                q.add(right);
            }

            if (q.size() > k) {
                left = q.poll() + 1; // 收缩左边界
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}