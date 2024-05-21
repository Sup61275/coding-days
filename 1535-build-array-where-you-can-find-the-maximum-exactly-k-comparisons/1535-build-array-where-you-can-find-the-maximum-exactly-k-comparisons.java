class Solution {
    int N;
    int M;
    int K;
    int MOD = 1000000007; 
    int[][][] dp = new int[51][51][101]; 

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                for (int l = 0; l <= M; l++) { 
                    dp[i][j][l] = -1; 
                }
            }
        }
        return solve(0, 0, 0);
    }

    private int solve(int idx, int searchCost, int maxSoFar) {
        if (idx >= N) {
            if (searchCost == K) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][searchCost][maxSoFar] != -1) {
            return dp[idx][searchCost][maxSoFar];
        }
        
        int result = 0;
        for (int i = 1; i <= M; i++) { 
            if (i > maxSoFar) {
                result = (result + solve(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result + solve(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }
        dp[idx][searchCost][maxSoFar] = result;
        return result;
    }
}
