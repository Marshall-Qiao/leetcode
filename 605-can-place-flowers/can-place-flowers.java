class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // [1,0,0,0,0,0,1,0,0] 

        // n=3 （3-2 +1）/2  1   
        // n= 4 (4-2 +1)/2   1
        // (n-2+1)/2
        int[] all = new int[flowerbed.length+3];
        all[0] = 0;
        all[flowerbed.length+1] = 0;
        all[flowerbed.length+2] = 1;
        for(int i = 0; i < flowerbed.length; i++) all[i+1] = flowerbed[i];

        int l = 0, start = 0, count= 0;
        while (l < all.length) {
            if (all[l] == 1) {
                int m = l - start;
                count += Math.max(0,(m-2+1)/2);
                start = l+1;
            }
            l++;
        }

        return count >= n;
    }
}