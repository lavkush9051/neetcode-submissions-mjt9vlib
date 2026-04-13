class Solution {
    public int trap(int[] height) {

        int l = 0;
        int r = height.length -1;

        int Lmax = height[l];
        int Rmax = height[r];

        int total = 0;

        while( l < r){
            if(Lmax < Rmax){
                l++;
                Lmax = Math.max(Lmax, height[l]);
                total += Lmax - height[l];
            }else{
                r--;
                Rmax = Math.max(Rmax, height[r]);
                total += Rmax - height[r];
            }
        }
        return total;
    }
}
