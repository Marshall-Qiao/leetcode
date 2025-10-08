class Solution {
    public int search(int[] nums, int target) {
       //  nums = [4,5,6,7,0,1,2], target = 0
       //  l     mid    r
       //  0->4  3->7   6->2
       //  4-->0  5->1   6-->2
       //  4       4       5->2
       int l = 0, r = nums.length - 1;
       while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            boolean atIncreaseLeft = nums[l] < nums[mid] && nums[l] <= target &&  target < nums[mid];
            boolean atNoIncreaseLeft = nums[l] > nums[mid] && (nums[l] <= target ||  target < nums[mid]);
            if (atIncreaseLeft || atNoIncreaseLeft) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
       }
       return -1;
    }
}