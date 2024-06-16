class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
       List<List<Integer>>adj= new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       }
       for(int[] edge:edges){
        int u=edge[0];
        int v=edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
       }
        return dfs(adj,-1,0,hasApple);
       
    }
    int dfs(List<List<Integer>>adj,int parent,int curr, List<Boolean> hasApple){
        int time=0;
        for(int child:adj.get(curr)){
            if(child==parent){
                continue;
            }
            int time_broughtByChild=dfs(adj,curr,child,hasApple);
            if(time_broughtByChild>0||hasApple.get(child)==true){
                time+=time_broughtByChild+2;
            }
        }
        return time;
    }
}