class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
     
      
        Arrays.sort(citations);
        for(int i=0;i<n;i++){
            int var1=citations[i];
            int var2=n-i;
            if(var2<=var1){
                return var2;
            }
        }

        return 0;
     
    }
}
