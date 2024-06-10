class Solution {
    public int removeStones(int[][] stones) {
        int n =stones.length;
        boolean[]visited= new boolean[n];
        int group=0;
        for(int i=0;i<n;i++){
            if(visited[i]==true){
                continue;
            }else if(visited[i]==false){
                dfs(stones,i,visited);
                group++;
            }
        }
        return n-group;
    }
    void dfs(int[][] stones,int index, boolean[]visited){
        int n = stones.length;
        visited[index]=true;
     
        for(int i=0;i<n;i++){
        int r=stones[index][0];
        int c=stones[index][1];
        if((visited[i]==false)&&(stones[i][0]==r||stones[i][1]==c)){
            dfs(stones,i,visited);
        }
        }
    }
}