class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int res = 0;
        for(int i=0; i< height.length; i++){
            int maxLeftH = height[i];
            int maxRightH = height[i];

            for(int j = 0; j< i; j++){
                maxLeftH = Math.max(maxLeftH, height[j]);
            }

            for(int k = i+1; k< height.length; k++){
                maxRightH = Math.max(maxRightH, height[k]);
            }

            res = res + Math.min(maxLeftH, maxRightH) - height[i];

        }

        return res;
    }
}