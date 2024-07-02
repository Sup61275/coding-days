class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      int i=0,j=0;
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int n=Math.min(nums1.length,nums2.length);
      int[]result= new int[n];
      int idx=0;
      while(i<nums1.length&&j<nums2.length&&idx<n){
        if(nums1[i]==nums2[j]){
            result[idx]=nums1[i];
            i++;
            j++;
            idx++;
        }else if(nums1[i]<nums2[j]){
            i++;
        }else{
            j++;
        }
      }
        return Arrays.copyOfRange(result,0,idx);
    }
}