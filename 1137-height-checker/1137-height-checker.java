class Solution {
    public int heightChecker(int[] heights) {
        int []dummy= new int[heights.length];
        for(int i=0;i<heights.length;i++){
            dummy[i]=heights[i];
        }
        Arrays.sort(dummy);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=dummy[i]){
                count++;
            }
        }
        return count;
    }
}