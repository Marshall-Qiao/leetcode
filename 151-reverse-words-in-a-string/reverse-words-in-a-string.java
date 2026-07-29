class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] list = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if(list[i] != null && !"".equals(list[i])) sb.append(list[i] + " ");
        }
        return sb.toString().trim();
    }
}