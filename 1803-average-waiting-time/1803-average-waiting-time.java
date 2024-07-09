class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n=customers.length;
        int start_time=0;
        double wait_time=0;
        for(int i=0;i<n;i++){
            int arrival_time=customers[i][0];
            int preparation_time=customers[i][1];
            if(start_time<arrival_time){
                start_time=arrival_time;
            }
            wait_time+=(start_time+preparation_time-arrival_time);
            start_time+=preparation_time;
        }
        
        return wait_time/n;

    }
}