class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int days=0;
        int []result=new int[n];
        Stack<Integer>st= new Stack<>();
        int idx=n-1;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                result[idx]= 0;
            }else{
                result[idx]=st.peek()-i;
            }
            idx--;
            st.push(i);
           
        }
        return result;
    }
}