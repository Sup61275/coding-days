class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        List<int[]>list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{capacity[i],rocks[i]});
        }
        Collections.sort(list,(a,b)->(a[0]-a[1]-(b[0]-b[1])));
        int count=0;
        for(int i=0;i<n;i++){
            int diff=list.get(i)[0]-list.get(i)[1];
            if(diff==0){
                count++;
            }else if (additionalRocks >= diff) {
                additionalRocks -= diff;
                count++;
            }
            if(additionalRocks<=0){
                break;
            }
            
        }
        return count;

    }
}