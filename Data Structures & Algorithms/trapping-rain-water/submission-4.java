class Solution {
    public int trap(int[] height) {
        int l=0; int r = 0; int lmm=0; int rmm = 0;
        r = height.length-1;
        int res = 0;

        while(l<r){
            if(height[l] <= height[r]){
                if(height[l] < lmm){
                    res += lmm - height[l];
                }else{
                    lmm = height[l];
                }
                l++;
            }else{
                if( height[r] < rmm){
                    res += rmm - height[r];
                }else{
                    rmm = height[r];
                }
                r--;
            }
        }
        return res;
    }
}
