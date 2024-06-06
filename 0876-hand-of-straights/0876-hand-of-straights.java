class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand); 
        int groupNumber = 0;
        
        if (n % groupSize != 0) {
            return false;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) { 
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while(!map.isEmpty()){
            int currEle=map.firstKey();
            for(int j=0;j<groupSize;j++){
                if(!map.containsKey(currEle+j)){
                    return false;
                }
                map.put(currEle+j,map.get(currEle+j)-1);
                if(map.get(currEle+j)==0){
                    map.remove(currEle+j);
                }
            }
        }
      
        return true;
       
    }
}