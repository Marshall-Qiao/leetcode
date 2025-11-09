class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curr = nums[0], matchIndx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (curr != nums[i]) {
                nums[matchIndx] = nums[i];
                matchIndx++;
                curr = nums[i];
            }
        }
        return matchIndx;
    }
}