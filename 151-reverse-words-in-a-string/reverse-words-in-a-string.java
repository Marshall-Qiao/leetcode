class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strList = s.split(" ");
        String res = "";
        boolean isLastTrim = true;
        for (int i = strList.length - 1; i >= 0; i--) {
            res += (isLastTrim ? "" : " ") + strList[i];
            isLastTrim = (strList[i]).equals("");
        } 
        return res;
    }
}