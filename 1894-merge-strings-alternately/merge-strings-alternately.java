class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = 0, m = 0;
        StringBuffer sb = new StringBuffer();
        while (n < word1.length() || m < word2.length()) {
            if(n < word1.length()){
                sb.append(word1.charAt(n));
                n++;
            } 
            if(m < word2.length()){
                sb.append(word2.charAt(m));
                m++;
            } 
        }
        while(n < word1.length()){
                sb.append(word1.charAt(n));
                n++;
        } 
        while(m < word2.length()){
                sb.append(word2.charAt(m));
                m++;
        } 
        return sb.toString();
    }
}