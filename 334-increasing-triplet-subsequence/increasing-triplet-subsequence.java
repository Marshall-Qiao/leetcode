class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) { // 更新最小值
                first = num;
            } else if (num <= second) { // 更新第二小值
                second = num;
            } else { // 找到 third > second
                return true;
            }
        }
        return false;
    }
}