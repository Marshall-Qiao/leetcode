class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int from = 0, size = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                from = Math.max(from, map.get(chars[i]) + 1);
            }
            size = Math.max(size, i - from + 1);
            map.put(chars[i], i);
        }
        return size;
    }
}