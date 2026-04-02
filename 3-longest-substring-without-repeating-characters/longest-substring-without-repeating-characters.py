class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        location_map = {}
        max_val, last_idx = 0, 0
        for i in range(len(s)):
            last_idx = max(last_idx, location_map.get(s[i], -1) + 1) 
            max_val = max(max_val, i - last_idx + 1)
            location_map[s[i]] = i
        return max_val