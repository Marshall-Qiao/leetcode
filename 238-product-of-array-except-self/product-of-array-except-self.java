class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        int[] end = new int[nums.length];
        end[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i > 0; i--) {
            end[i] = end[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i == 0) {
                result[i] = end[i+1];
            } else if (i == nums.length - 1) {
                result[i] = pre[i-1];
            } else {
                 result[i] = pre[i-1] * end[i+1];
            }
        }
        return result;
    }
}