class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuffer sb = new StringBuffer();
        // 1 7 13
        // n * (行 + 行 - 2) + 当前行 ，（n+1） * (行) + 行 -   n 0.1.2.3.4
        // n * (行 + 行 - 2) + 当前行， （n+1） * (行) + 行 
        // those two same no need add;     
        // 1       7           13
        // 2    6  8       12  14
        // 3  5    9   11      15
        // 4       10
        int round = 2 * numRows - 2;
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i < s.length()/numRows + 1; i++) {
                int fIdx = i * round + row;
                if (fIdx > s.length() - 1) break;
                sb.append(s.charAt(fIdx) + "");

                if (row == 0 || row == numRows - 1){
                     continue;
                }

                int sIdx = i * round + round - row ;
                if (sIdx > s.length() - 1) break;
                sb.append(s.charAt(sIdx) + "");
            }
        }
        return sb.toString();
    }
}