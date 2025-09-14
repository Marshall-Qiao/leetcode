class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // convert to LIS
        Arrays.sort(envelopes,(first,second)-> first[0] == second[0] ? (second[1]-first[1]) : (first[0]-second[0]));

       int[] tail = new int[envelopes.length]; 
       int len = 0;
       for(int[] one : envelopes){
         int h = one[1];
         int i = getSearchIndex(tail,h,len);
         tail[i] = h;
         if(i == len) len++;
       }
       return len;
    }
    // arr[0..len) find first >= target index
    public int getSearchIndex(int[] tail,int h,int len){
        int l = 0, r = len;
        while(l<r){
            int mid = l + (r-l)/2;
            if(tail[mid] < h){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}