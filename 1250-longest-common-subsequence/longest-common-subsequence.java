class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] res = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char b = text2.charAt(j - 1);
                if (a == b) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[text1.length()][text2.length()];
    }
}