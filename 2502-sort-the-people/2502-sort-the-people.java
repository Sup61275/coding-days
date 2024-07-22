class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=heights.length;
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(heights[i],i);
        }
        Arrays.sort(heights);
        String[]result= new String[n];
        for(int i=0;i<n;i++){
            int idx=map.get(heights[i]);
            result[i]=names[idx];
        }
        int i=0,j=n-1;
        while(i<j){
            String temp=result[i];
            result[i]=result[j];
            result[j]=temp;
            i++;
            j--;
        }
        return result;
    }
}