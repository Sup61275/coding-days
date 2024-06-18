class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       int n =profit.length;
       List<int[]>jobs= new ArrayList<>();
       for(int i=0;i<n;i++){
        jobs.add(new int[]{difficulty[i],profit[i]});
       }
       jobs.sort(Comparator.comparingInt(a->a[0]));
       Arrays.sort(worker);
       int i=0,ans=0,bestprofit=0;
       for(int ability:worker){
        while(i<n && jobs.get(i)[0]<=ability){
           bestprofit=Math.max(bestprofit,jobs.get(i)[1]);
           i++;
        }
          ans+=bestprofit;
       }
       return ans;
    }
}