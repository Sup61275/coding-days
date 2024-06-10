class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
       
        int province=0;
        boolean[]visited= new boolean[n];
        for(int i=0;i<n;i++){
         if(!visited[i]){
                dfs(isConnected,visited,i);
                province++;
            }
        
        }
        return province;
    }
     void dfs(int[][] isConnected, boolean[] visited, int u) {
        int n = isConnected.length;
        visited[u] = true;
        for (int v = 0; v < n; v++) {
            if (!visited[v] && isConnected[u][v] == 1) {
                dfs(isConnected, visited, v);
            }
        }
    }
}