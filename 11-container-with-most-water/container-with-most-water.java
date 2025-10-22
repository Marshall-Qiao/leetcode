class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int min_height = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * min_height);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}