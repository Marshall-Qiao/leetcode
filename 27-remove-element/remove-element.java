class Solution {
    public int removeElement(int[] nums, int val) {
        int lastIndx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[lastIndx] = nums[i];
                lastIndx++;
            }
        } 
        return lastIndx;
    }
}