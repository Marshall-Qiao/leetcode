class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, max = 0;
        for (int r = 0; r < s.length(); r++) {
            char now = s.charAt(r);
            Integer idx = map.get(now);
            if (idx != null){
                l = Math.max(l , idx + 1);
            } 
            max = Math.max(max , r - l + 1);
            map.put(now, r);
        }
        return max;
        // int max = 0, l = 0, r = 0;
        // while (r < s.length()){
        //     String tempStr = s.substring(l, r);
        //     int idx = tempStr.indexOf(s.charAt(r) + "");
        //     if(idx > -1) {
        //         l += idx + 1;
        //     } 
        //     max = Math.max(max, r - l + 1);
        //     r++;
        // }
        // return max;
    }
}