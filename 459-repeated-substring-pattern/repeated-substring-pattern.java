class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubleStr = s + s;
        String str = doubleStr.substring(1,doubleStr.length()-1);
        return str.contains(s);
    }
}