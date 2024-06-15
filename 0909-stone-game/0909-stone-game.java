class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][][] memo = new Integer[n][n][2]; 
        int alice = solve(piles, 0, n - 1, 1, memo);
        int bob = solve(piles, 0, n - 1, 0, memo);
        return alice > bob;
    }

    int solve(int[] piles, int start, int end, int person, Integer[][][] memo) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end][person] != null) {
            return memo[start][end][person];
        }
        if (person == 1) {
            // Alice's turn (maximize)
            int takeStart = piles[start] + solve(piles, start + 1, end, 0, memo);
            int takeEnd = piles[end] + solve(piles, start, end - 1, 0, memo);
            memo[start][end][person] = Math.max(takeStart, takeEnd);
        } else {
            // Bob's turn (minimize)
            int takeStart = solve(piles, start + 1, end, 1, memo);
            int takeEnd = solve(piles, start, end - 1, 1, memo);
            memo[start][end][person] = Math.min(takeStart, takeEnd);
        }

        return memo[start][end][person];
    }
}
