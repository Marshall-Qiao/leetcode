class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        Set<String> elems = new HashSet<String>();
        int i = 0, j = 0;
        while(i <= n-1){
            elems.add(i+","+j);
            i++;
            j++;
        }
        i = n-1; j = 0;
        while(i >= 0){
            elems.add(i+","+j);
            i--;
            j++;
        }
        for(i = 0; i<n;i++){
            for(j = 0; j <n;j++){
                if(elems.contains(i+","+j)){
                    if(grid[i][j] <= 0)return false;
                }else{
                    if(grid[i][j] != 0)return false;
                } 
            }
        }
        return true;
    }
}