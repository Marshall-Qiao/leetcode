class Solution {
 
    public String longestPalindrome(String s) {
        if(s.length()<= 1) return s;

        int l = 0, r = 0;
        for(int i = 0; i< s.length()-1;i++){
           int nowLen = r-l+1;
           int oneLen = findLongest(s,i,i);
           if(nowLen < oneLen){
                l = i-oneLen/2;
                r = i+oneLen/2;
           }
           int doubleLen = findLongest(s,i,i+1);
           if(nowLen < doubleLen){
                l = i-doubleLen/2+1;
                r = i+doubleLen/2;
           }
        } 
        return s.substring(l,r+1);
    }
    public int findLongest(String s,int l, int r) {
        if(s.charAt(l) != s.charAt(r)){
            return 1;
        }
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

}