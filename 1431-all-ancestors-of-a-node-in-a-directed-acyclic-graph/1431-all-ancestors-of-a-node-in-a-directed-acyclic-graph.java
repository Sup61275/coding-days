class Solution {
    private void dfs(int u,Map<Integer, List<Integer>> adj,boolean[]visited){
        visited[u]=true;
        for(int v:adj.getOrDefault(u,new ArrayList<>())){
            if(!visited[v]){
                dfs(v,adj,visited);
            }
        }

    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
           adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        for(int u=0;u<n;u++){
        List<Integer>res= new ArrayList<>();
        boolean[]visited=new boolean[n];
        dfs(u,adj,visited);
        for(int i=0;i<n;i++){
           if(i!=u&&visited[i]){
            res.add(i);
           }
        
        }
         result.add(new ArrayList<>(res)); 
      }
      
    return result;
    }
    
}