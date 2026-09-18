class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0, r = 0;
        while(r < t.length() && l < s.length()) {
            char a = s.charAt(l);
            char b = t.charAt(r);
            r++;
            if (a == b) l++;
        }
        return l >= s.length();
    }
}