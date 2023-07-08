class Solution {
    public long putMarbles(int[] arr, int k) {
        int n=arr.length;
        int wt[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            wt[i]=arr[i]+arr[i+1];
        }
        Arrays.sort(wt);
        long ans=0;
        for(int i=0;i<k-1;i++){
            ans+=wt[n-2-i]-wt[i];
        }

        return ans;
    }
}