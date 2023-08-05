class Solution {
    public boolean containsDuplicate(int[] nums) {
    ArrayList <Integer> list= new ArrayList<>();
    HashSet<Integer> set= new HashSet<>();
    for(int i=0;i<nums.length;i++){
        list.add(nums[i]);
        set.add(nums[i]);
        if(set.size()<list.size()){
            return true;
        }
    }
    return false;

    }
}