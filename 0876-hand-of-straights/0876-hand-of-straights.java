class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand); 
        if (n % groupSize != 0) {
            return false;
        }
        
     HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : hand) { 
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num:hand){
            if(map.get(num)==0){
                continue;
            }
            for(int j=0;j<groupSize;j++){
                int currEle=num+j;
                if(map.getOrDefault(currEle,0)==0){
                    return false;
                }
                map.put(currEle,map.get(currEle)-1);
                

            }
        }
      
        return true;
       
    }
}