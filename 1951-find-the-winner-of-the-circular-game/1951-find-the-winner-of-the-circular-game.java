class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>que= new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.add(i);
        }
        while(que.size()>1){
            int i=0;
         while(i<k-1){
            int remove_ele=que.poll();
            que.add(remove_ele);
            i++;
           }
            que.poll();
        }
        return que.poll();
    }
}