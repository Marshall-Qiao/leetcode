class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int sum = 0, left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    sum += leftMax - height[left];
                } else {
                    leftMax = height[left];
                } 
                left++;
            } else {
                 if (height[right] < rightMax) {
                    sum += rightMax - height[right];
                } else {
                    rightMax = height[right];
                } 
                right--;
            }
        }
        return sum;
    }
}