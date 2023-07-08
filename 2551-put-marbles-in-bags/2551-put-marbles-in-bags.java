class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        
        int[] pairWeights = new int[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        
        Arrays.sort(pairWeights);
        long answer = 0;
        for (int i = 0; i < k - 1; i++) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}