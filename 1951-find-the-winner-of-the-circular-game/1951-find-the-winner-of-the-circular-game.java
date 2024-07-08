class Solution {
    public int findTheWinner(int n, int k) {
        int resultant_idx=find_idxOfWinner(n,k);
        return resultant_idx+1;
       
    }
    int find_idxOfWinner(int n,int k){
        if(n==1){
            return 0;
        }
        int idx=find_idxOfWinner(n-1,k);
        idx=(idx+k)%n;
        return idx;
    }
}
