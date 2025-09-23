class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 =  version1.split("\\.");
        String[] v2 =  version2.split("\\.");
        int n = Math.min(v1.length,v2.length);
        for(int i = 0; i < n; i++){
            int  a = (int)Integer.valueOf(v1[i]);
            int  b = (int)Integer.valueOf(v2[i]);
            if(a < b) return -1;
            if(a > b) return 1;
        }
        int m = Math.max(v1.length,v2.length);
        for(int i = n;i < m;i++){
            if(v1.length>n && ((int)Integer.valueOf(v1[i]) > 0) ) return 1;
            if(v2.length>n && ((int)Integer.valueOf(v2[i]) > 0) ) return -1;
        }
        return 0;
    }
}