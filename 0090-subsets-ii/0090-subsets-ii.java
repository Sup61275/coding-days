class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<Integer>temp= new ArrayList<>();
       List<List<Integer>>result=new ArrayList<>();
       Set<List<Integer>>set= new HashSet<>();
       Arrays.sort(nums);
       solve(nums,0,set,temp,result);
       result.addAll(set);
       return result; 
    }
    private void solve(int[] nums,int i,Set<List<Integer>>set, List<Integer>temp,List<List<Integer>>result){
        if(i>=nums.length){
            set.add(new ArrayList(temp));
            return;
        }
     
            temp.add(nums[i]);
            solve(nums,i+1,set,temp,result);
            temp.remove(temp.size()-1);
            solve(nums,i+1,set,temp,result);
    }
}