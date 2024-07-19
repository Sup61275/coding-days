class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]>list= new ArrayList<>();
        int n=position.length;
        for(int i=0;i<n;i++){
            list.add(new int[]{position[i],speed[i]});
        }
        list.sort((a, b) -> Integer.compare(b[0], a[0]));
        int fleet=0;
        double prevCarTime=0;
        for(int i=0;i<n;i++){
            double currCarTime=(double)(target-list.get(i)[0])/list.get(i)[1];
           if(currCarTime>prevCarTime){
                prevCarTime=currCarTime;
                fleet++;
            }
           

        }
        return fleet;
    }
}