class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        int[][] res = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
               res[i][m-j-1] = image[i][j]; 
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
               res[i][j] = res[i][j] == 0 ? 1 : 0; 
            }
        }
        return res; 
    }
}