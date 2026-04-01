class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, idx, r = 0, 0, len(nums) - 1
        while idx <= r:
            if nums[idx] == 0: 
                nums[idx], nums[l] =  nums[l], nums[idx]
                l += 1
                idx += 1
            elif nums[idx] == 2:
                nums[idx], nums[r] =  nums[r], nums[idx]
                r -= 1
            else:
                idx += 1            
    
        