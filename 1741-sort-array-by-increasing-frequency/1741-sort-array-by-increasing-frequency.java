class Solution {
    public int[] frequencySort(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>list= new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(nums[i]);
        }
        Collections.sort(list,(a,b)->{
            int compare=Integer.compare(map.get(a),map.get(b));
            if(compare==0){
                return Integer.compare(b,a);
            }
            return compare;
        });
        int[]result= new int[n];
        for(int i=0;i<n;i++){
            result[i]=list.get(i);
        }
        return result;
    }
}