class Solution {
    public int maxProfit(int[] arr) {
        int min=arr[0];
        int maxprofit=0;
        int i;
        for(i=1;i<arr.length;i++){
            min=Math.min(min,arr[i]);
            int profit= arr[i]-min;
            maxprofit=Math.max(maxprofit,profit);
        }
        
        return maxprofit;
    }
}