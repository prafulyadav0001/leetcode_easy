class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
        
		for (int i = 1; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			max = Math.max(dp[i], max);
		}
		return max;
    }
}