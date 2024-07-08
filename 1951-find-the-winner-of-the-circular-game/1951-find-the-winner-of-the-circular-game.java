class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>que= new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.add(i);
        }
        while(que.size()>1){
           for(int i=0;i<k-1;i++){
            int remove_ele=que.poll();
            que.add(remove_ele);
           }
            que.poll();
        }
        return que.poll();
    }
}