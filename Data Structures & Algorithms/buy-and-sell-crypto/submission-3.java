class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while(l < r && r<prices.length){
            if((prices[l] - prices[r]) > 0){
                l=r;
            }else{
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }r++;
        }
        return maxProfit;
    }
}
