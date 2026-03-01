class Solution {
    public int[] sortArray(int[] nums) {
        sortMergeArray(nums, 0, nums.length - 1);
        return nums;
    }

    public void sortMergeArray(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sortMergeArray(nums, left, mid);
        sortMergeArray(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right -left + 1];
        int n = left, m = mid + 1, idx = 0;
        while (n <= mid && m <= right) {
            if (nums[n] > nums[m]) {
                temp[idx++] = nums[m++];
            } else {
                temp[idx++] = nums[n++];
            }
        }
        while (n <= mid) {
            temp[idx++] = nums[n++];
        }
        while (m <= right) {
            temp[idx++] = nums[m++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}