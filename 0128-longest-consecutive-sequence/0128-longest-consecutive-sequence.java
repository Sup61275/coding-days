class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer>map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int count=0,max_count=0;
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            if(map.containsKey(current)){
                count=1;
                map.remove(current);
            
            int next=current+1;
            while(map.containsKey(next)){
                count++;
                map.remove(next);
                next++;

            }
            int prev=current-1;
            while(map.containsKey(prev)){
                count++;
                map.remove(prev);
                prev--;
            }
            max_count=Math.max(count,max_count);
        }
        }
        return max_count;
    }
}