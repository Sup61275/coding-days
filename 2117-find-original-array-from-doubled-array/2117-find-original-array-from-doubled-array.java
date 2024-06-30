class Solution {
    public int[] findOriginalArray(int[] nums) {
        int n=nums.length;
        if(n%2!=0){
            return new int[0];
        }
        Arrays.sort(nums);
        Map<Integer,Integer>map= new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[]result= new int[n/2];
        int idx=0;
        for(int num:nums){
            if(map.get(num)==0){
                continue;
            }
            if(num==0){
                if(map.getOrDefault(num,0)<2){
                    return new int[0];
                }
                map.put(num,map.getOrDefault(num,0)-2);
            }else{ 
            if(map.getOrDefault(num*2,0)==0){
                return new int[0];
            }
            result[idx]=num;
            idx++;
            map.put(num,map.getOrDefault(num,0)-1);
            map.put(num*2,map.getOrDefault(num*2,0)-1);
            }
        }
        return result;
    }
}