class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() <= 1) return 0;
        int pre = 0,  curr = 1, res = 0;
        for(int i =0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                curr++;
            }else{
                res += Math.min(pre,curr);
                pre = curr;
                curr = 1;
            }
        }
       res += Math.min(pre,curr);

        return res;
    }
}