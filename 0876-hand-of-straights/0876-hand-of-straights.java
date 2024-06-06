class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand); 
        int groupNumber = 0;
        
        if (n % groupSize != 0) {
            return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : hand) { 
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int i = 0;
        while (i < n) {
            int groupEle = hand[i];
            int ele = 0;
            
            if (map.containsKey(groupEle)) {
                for (int j = 0; j < groupSize; j++) {
                    if (!map.containsKey(groupEle + j) || map.get(groupEle + j) == 0) {
                        ele = 0;
                        break;
                    }
                    map.put(groupEle + j, map.get(groupEle + j) - 1);
                    if (map.get(groupEle + j) == 0) {
                        map.remove(groupEle + j);
                    }
                    ele++;
                }
            } else {
                ele = 0;
            }
            
            if (ele == groupSize) {
                groupNumber++;
            }
            
           
            while (i < n && map.getOrDefault(hand[i], 0) == 0) {
                i++;
            }
        }
        
        return groupNumber == n / groupSize;
    }
}