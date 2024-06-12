class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>>result= new ArrayList<>();
        List<Integer>temp= new ArrayList<>();
        int source=0;
        int target=n-1;
        dfs(graph,source,n-1,result,temp);
        return result;

        
    }
    void dfs(int[][] graph,int u, int target,List<List<Integer>>result,   List<Integer>temp){
    temp.add(u);
    if(u==target){
        result.add(new ArrayList(temp));

    }else{
        for(int v:graph[u]){
            dfs(graph,v,target,result,temp);
        }
    }
    temp.remove(temp.size()-1);
}
}