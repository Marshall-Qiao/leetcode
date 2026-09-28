class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, l = 0, r = 0;
        while (r < s.length()){
            String tempStr = s.substring(l, r);
            int idx = tempStr.indexOf(s.charAt(r) + "");
            if(idx > -1) {
                l += idx + 1;
            } 
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}