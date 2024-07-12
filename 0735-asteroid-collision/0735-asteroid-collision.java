class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>st= new Stack<>();
        for( int i=0;i<n;i++){
            while(!st.isEmpty()&& st.peek()>0 && asteroids[i]<0){
                if(Math.abs(asteroids[i])<st.peek()){
                    asteroids[i]=0;
                    break;
                }else if(Math.abs(asteroids[i])==st.peek()){
                    asteroids[i]=0;
                    st.pop();
                }else if(Math.abs(asteroids[i])>st.peek()){
                    st.pop();
                }
            }
            if(asteroids[i]!=0){
            st.push(asteroids[i]);
            }
        }
        int idx=st.size()-1;
         int[] result= new int[st.size()];
        while(!st.isEmpty()){
            result[idx--]=st.pop();
        }
        return result;
    }
}