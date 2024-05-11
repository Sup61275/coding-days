class Solution {
    int[][] memo= new int [1001][1001];
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
      
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
          return solve(0, -1, words);
    }

    private int solve(int idx, int prev, String[] words) {
        int n =words.length;
        if (idx >= words.length) {
            return 0;
        }
        if(prev!=-1&&memo[prev][idx]!=-1){
            return memo[prev][idx];
        }
        int take=0;
        
        int nottake = solve(idx + 1, prev, words);
        
        if (prev == -1 || diffOneCharacter(words[prev], words[idx])) {
           take = 1 + solve(idx + 1, idx, words);
           if(prev!=-1)
           memo[prev][idx]=Math.max(take,nottake);
        }
        return Math.max(take, nottake);
    }
boolean diffOneCharacter(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        if (M >= N || N - M != 1)
            return false;

        int i = 0, j = 0;
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M;
    }
}
