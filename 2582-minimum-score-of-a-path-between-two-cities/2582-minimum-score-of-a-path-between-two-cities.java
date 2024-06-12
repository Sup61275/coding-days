class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] vec : roads) {
            int u = vec[0];
            int v = vec[1];
            int c = vec[2];
            adj[u].add(new int[]{v, c});
            adj[v].add(new int[]{u, c});
        }
        int[] result = {Integer.MAX_VALUE}; 
        boolean[] visited = new boolean[n + 1];
        dfs(1, adj, result, visited); 
        return result[0];
    }

    void dfs(int u, List<int[]>[] adj, int[] result, boolean[] visited) {
        visited[u] = true;
        for (int[] pair : adj[u]) {
            int v = pair[0];
            int c = pair[1];
            result[0] = Math.min(result[0], c);
            if (!visited[v]) {
                dfs(v, adj, result, visited);
            }
        }
    }
}
