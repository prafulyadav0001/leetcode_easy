class Solution {
    public int maxCoins(int[] nums) {
         int n = nums.length;
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int leftVal = 1;
                    int rightVal = 1;

                    if (i != 0) {
                        leftVal = nums[i - 1];
                    }
                    if (j != n - 1) {
                        rightVal = nums[j + 1];
                    }

                    int leftCoins = 0;
                    int rightCoins = 0;

                    if (i != k) {
                        leftCoins = dp[i][k - 1];
                    }
                    if (j != k) {
                        rightCoins = dp[k + 1][j];
                    }

 dp[i][j] = Math.max(dp[i][j], leftVal * nums[k] * rightVal + leftCoins + rightCoins);
                }
            }
        }

        return dp[0][n - 1];
    }
}