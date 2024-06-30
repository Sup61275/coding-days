class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length%2!=0){
            return false;
        }
        Arrays.sort(arr);
        Map<Integer,Integer>map= new HashMap<>();
        for(int itr:arr){
            map.put(itr,map.getOrDefault(itr,0)+1);
        }
        for(int i=0;i<arr.length;i++){
            if(map.getOrDefault(arr[i],0)!=0&&map.getOrDefault(arr[i]*2,0)!=0){
                map.put(arr[i],map.get(arr[i])-1);
                map.put(arr[i]*2,map.get(arr[i]*2)-1);

            }
        }
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])!=0){
                return false;
            }
        }
        return true;
    }
}