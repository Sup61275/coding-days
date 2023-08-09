class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap <Integer,Integer>map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
          
                if (map.containsKey(nums[i])&&i-map.get(nums[i])<=k&& i-map.get(nums[i])>0) {
               
                    return true;
                
            }
            map.put(nums[i],i);
          
        }
   
        return false;
    }
}
