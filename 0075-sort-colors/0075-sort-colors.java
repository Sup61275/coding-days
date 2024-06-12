class Solution {
    public void sortColors(int[] nums) {
     int count1=0;
     int count2=0;
     int count3=0;
     HashMap<Integer,Integer>map= new HashMap<>();
     for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
     }
     if(map.containsKey(0)){
        count1=map.get(0);
     }
      
        if (map.containsKey(1)) {
            count2 = map.get(1);
        }
        
        if (map.containsKey(2)) {
            count3 = map.get(2);
        }
    
     for(int i=0;i<nums.length;i++){
        if(count1>0){
            nums[i]=0;
            count1--;

        }else if(count2>0){
            nums[i]=1;
            count2--;
        }else{
            nums[i]=2;
            count3--;
        }
     }
    
    }
}
