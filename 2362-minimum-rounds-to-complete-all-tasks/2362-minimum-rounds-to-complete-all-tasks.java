class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        int round = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (int count:map.values()) {
            
            if (count < 2) {
                return -1; 
            } 
            if(count%3==0){
                round+=count/3;
            }
            else{
                round+=count/3+1;
            }
        }

        return round;
    }
}

