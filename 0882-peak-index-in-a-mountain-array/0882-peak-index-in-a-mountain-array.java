class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n =arr.length;
        int lb=0;
        int ub=n-1;
       while(lb<ub){
        int mid=lb+(ub-lb)/2;
        if(arr[mid]<arr[mid+1]){
            lb=mid+1;
        }else{
            ub=mid;
        }
      
       }
         return ub;
    }
}