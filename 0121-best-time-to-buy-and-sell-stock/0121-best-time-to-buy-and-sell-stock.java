class Solution {
    public int maxProfit(int[] arr) {
        int min =arr[0];
        int maxp=0;
        for(int i=1;i<arr.length;i++){
            min= Math.min(min,arr[i]);
            int profit=arr[i]-min;
            maxp=Math.max(maxp,profit);
        }
        return maxp;
    }
}