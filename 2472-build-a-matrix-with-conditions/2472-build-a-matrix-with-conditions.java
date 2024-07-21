class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] mat = new int[k][k];
        List<Integer> row = topoSort(k, rowConditions);
        List<Integer> col = topoSort(k, colConditions);
        if (row.isEmpty() || col.isEmpty()) {
            // If topological sorting is not possible, return an empty matrix
            return new int[0][0];
        }

        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            rowPos.put(row.get(i), i);
            colPos.put(col.get(i), i);
        }
        
        for (int i = 0; i < k; i++) {
            int val = row.get(i);
            int r = rowPos.get(val);
            int c = colPos.get(val);
            mat[r][c] = val + 1; 
        }
        
        return mat;
    }
    List<Integer> topoSort(int n, int[][] edges) {
        // Create adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0] - 1; 
            int v = edge[1] - 1; 
            adj[u].add(v);
        }
        
        Stack<Integer> st = new Stack<>();
        List<Integer> order = new ArrayList<>();
        int[] visited = new int[n];
        boolean[] hasCycle = {false};
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, st, visited, hasCycle);
                if (hasCycle[0]) {
                    return new ArrayList<>(); // Has cycle, so no topological sort possible
                }
            }
        }
        
        while (!st.isEmpty()) {
            order.add(st.pop());
        }
        
        return order;
    }
    void dfs(int node, List<Integer>[] adj, Stack<Integer> st, int[] visited, boolean[] hasCycle) {
        // visited == 1 (dfs ongoing), visited == 2 (marked as visited), visited == 0 (not visited)
        visited[node] = 1;
        for (int v : adj[node]) {
            if (visited[v] == 0) {
                dfs(v, adj, st, visited, hasCycle);
            } else if (visited[v] == 1) {
                hasCycle[0] = true;
                return;
            }
        }
        visited[node] = 2;
        st.push(node);
    }
}
