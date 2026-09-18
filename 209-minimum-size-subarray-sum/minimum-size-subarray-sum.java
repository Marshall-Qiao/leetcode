class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;

        int min = nums.length, sum = 0, l = 0, r = 0;
        boolean isHit = false;
        while (r < nums.length) {
            if (nums[r] >= target) return 1;

            sum += nums[r];
            while (sum >= target) {
                isHit = true;
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++; 
            } 
            r++;
        }
        return isHit ? min : 0;
    }
}