class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> result = new ArrayList<>();
        Integer[] index = new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,(i,j)->Integer.compare(positions[i],positions[j]));
        Stack<Integer>st= new Stack<>();
        for(int currentIdx:index){
            if(directions.charAt(currentIdx)=='R'){
                st.push(currentIdx);
            }else{
                while(!st.isEmpty() && healths[currentIdx]>0){
                    int topIdx=st.pop();
                    if(healths[topIdx]>healths[currentIdx]){
                        healths[currentIdx]=0;
                        healths[topIdx]-=1;
                        st.push(topIdx);
                    }else if(healths[topIdx]<healths[currentIdx]){
                        healths[topIdx] = 0;
                        healths[currentIdx]-=1;
                    }else{
                        healths[topIdx]=0;
                        healths[currentIdx]=0;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(healths[i]>0){
                result.add(healths[i]);
            }
        }
        return result;
    }
}
