class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for n in range(len(nums)):
            if target - nums[n] in map:
                return [map[target - nums[n]], n]
            map[nums[n]] = n
        return []