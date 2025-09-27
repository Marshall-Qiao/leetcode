class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer l = 0,max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i <= s.length();i++){
            if(i == s.length()){
                max = Math.max(i-l,max);
            }else if(map.get(s.charAt(i)) != null && map.get(s.charAt(i)).intValue() >= l){
               max = Math.max(i-l,max);
               l = map.get(s.charAt(i))+1;
               map.put(s.charAt(i),i);
            }else{
               map.put(s.charAt(i),i);
            }
        }
        return max;
    }
}