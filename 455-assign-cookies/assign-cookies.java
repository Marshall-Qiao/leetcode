class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s == null || s.length == 0 || g == null || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gl = 0,sl = 0;
        int count = 0;
        while(gl<g.length && sl<s.length ){
            if(s[sl] >= g[gl]){
                count++;
                gl++;
            }
            sl++;
        }
        return count;
    }
}