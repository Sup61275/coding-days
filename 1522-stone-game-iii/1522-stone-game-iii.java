class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[][]memo=new int[2][n+1];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
       
        int alice = solve(stoneValue, 1, 0,memo);
        int bob = solve(stoneValue, 0, 0,memo);
        String res;
        if (alice > bob) {
            res = "Alice";
        } else if (alice < bob) {
            res = "Bob";
        } else {
            res = "Tie";
        }
        return res;
    }
    int solve(int[] stoneValue, int person, int i, int[][]memo) {
        int n = stoneValue.length;
        if (i >= n) {
            return 0;
        }
        if(memo[person][i]!=-1){
            return memo[person][i];
        }
        int score = 0;
        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int x = 1; x <= Math.min(3, n - i); x++) {
            score += stoneValue[i + x - 1];
            if (person == 1) {
                result = Math.max(result, score + solve(stoneValue, 0, i + x, memo));
            } else {
                result = Math.min(result, solve(stoneValue, 1, i + x,memo));
            }
        }
        return  memo[person][i]=result;
    }
}
