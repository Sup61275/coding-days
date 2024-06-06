class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num)==0){
                continue;
            }
            for(int j=0;j<k;j++){
                int currEle=num+j;
                if(map.getOrDefault(currEle,0)==0){
                    return false;
                }
                map.put(currEle,map.getOrDefault(currEle,0)-1);
            }
        }
        return true;
    }
}