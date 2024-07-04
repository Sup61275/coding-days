class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n=plantTime.length;
        List<int[]>list= new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{plantTime[i],growTime[i]});
        }
        Collections.sort(list,(a,b)->b[1]-a[1]);
        int prevplantDay=0;
        int bloomdays=0;
        for(int i=0;i<n;i++){
            int currplantdays=list.get(i)[0];
            int currgrowdays=list.get(i)[1];
            prevplantDay+=currplantdays;
            int currentblommdays=prevplantDay+currgrowdays;
            bloomdays=Math.max(currentblommdays,bloomdays);
        }
        return bloomdays;
    }
}