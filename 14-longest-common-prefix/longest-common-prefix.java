class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        char[] res = new char[strs[0].length()];
        for(int i = 0; i < strs[0].length();i++){
            char info = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length()-1 < i) return new String(res).trim();
                if(strs[j].charAt(i) != info) return new String(res).trim();
            }
            res[i] = info;
        }
        return new String(res).trim();
    }
   
}