class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        
      int linearsum = kadaneMaxSum(arr);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			arr[i] = arr[i] * -1;
		}
		int middlesum = kadaneMaxSum(arr);
		sum += middlesum;
		if (sum == 0) {
			return linearsum;
		}
		return Math.max(sum, linearsum);
    }
    
    
    
    
    int kadaneMaxSum(int[] arr){
       int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			ans = Math.max(ans, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return ans;
    }
}