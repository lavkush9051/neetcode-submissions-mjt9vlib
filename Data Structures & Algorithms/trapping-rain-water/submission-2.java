class Solution {
    public int trap(int[] height) {
        int res = 0;

        if(height == null || height.length == 0){
            return 0;
        }

        for(int i = 0; i< height.length; i++){
            int leftH = height[i];
            int rightH = height[i];

            for(int j =0; j<i; j++){
                leftH = Math.max(leftH, height[j]);
            }

            for(int k =i+1; k< height.length; k++){
                rightH = Math.max(rightH, height[k]);
            }

            res = res + Math.min(leftH, rightH) - height[i];
        }

        return res;
    }
}
