class Solution {
    public int longestSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int left = -1, max = 0, lastZero = -1;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = lastZero;
                lastZero = right;
            }
            max = Math.max(max, right - left);
        }
        return max - 1;
    }
}