class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    HashMap<Integer,Integer>map= new HashMap<>();
    int sum=0;
    map.put(0,-1);
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        int remainder=sum%k;
        if(!map.containsKey(remainder)){
            map.put(remainder,i);
        }else if(map.containsKey(remainder)&& (i-map.get(remainder)>=2)){
            return true;
        }
    }
    return false;
    }
}