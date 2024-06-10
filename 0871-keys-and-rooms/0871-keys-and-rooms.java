class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n =rooms.size();
        boolean[]visited= new boolean[n];
        dfs(rooms,visited,0);
        for(boolean x:visited){
            if(x==false){
                return false;
            }
        }
        return true;
    }
    void dfs(List<List<Integer>> rooms, boolean[]visited, int source){
        visited[source]=true;
        int n =rooms.size();
        for(int itr:rooms.get(source)){
            if(!visited[itr]){
                dfs(rooms,visited,itr);
            }
        }
    }
}