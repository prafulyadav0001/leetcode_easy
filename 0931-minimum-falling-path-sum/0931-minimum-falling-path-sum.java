class Solution {
    private int IMIN = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + matrix[i - 1][j];
                int ld = (j > 0)? matrix[i][j] + matrix[i - 1][j - 1] : IMIN;
                int rd = (j < n - 1)? matrix[i][j] + matrix[i - 1][j + 1] : IMIN;
                matrix[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        int min = IMIN;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[n - 1][i]);
        }

        return min;
    }
}