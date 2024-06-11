class Solution {
    int [][]directions={{0,-1},{0,1},{1,0},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        Queue<int[]>que= new LinkedList<>();
        que.offer(new int[]{entrance[0],entrance[1]});
        int steps=0;
        maze[entrance[0]][entrance[1]]='+';
        while(!que.isEmpty()){
            int size=que.size();
            for(int k=0;k<size;k++){
              int[]current=que.poll();
              int x=current[0];
              int y=current[1];
              if((x==0||x==m-1||y==0||y==n-1)&&(!(x==entrance[0]&&y==entrance[1]))){
                return steps;
              }
              for(int[]dir:directions){
                int i=x+dir[0];
                int j=y+dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == '.') {
                    que.offer(new int[]{i,j});
                    maze[i][j]='+';
                }
              }
            }
            steps++;
        }
    return -1;
    }
}