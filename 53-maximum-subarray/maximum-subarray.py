class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_val, curr_max = nums[0], 0
        for num in nums:
            curr_max += num
            max_val = max(curr_max, max_val)
            if curr_max < 0: curr_max = 0
        return max_val