class Solution {
    public int maximumGain(String s, int x, int y) {
       int n=s.length();
       String maxStr=(x>y)?"ab":"ba";
       String minStr=(x<y)?"ab":"ba";
       int points=0;

       //1st pass for max
       String removeFirst=removeAndScore(s,maxStr);
       int l=n-removeFirst.length();
       points+=(l/2)*Math.max(x,y);

       //2nd pass for min
       String removeSecond=removeAndScore(removeFirst,minStr);
       int k= removeFirst.length()-removeSecond.length();
       points+=(k/2)*Math.min(x,y);
       
       return points;

    }
    
    private String removeAndScore(String s, String str) {
       Stack<Character>st= new Stack<>();
       for(char ch:s.toCharArray()){
        if(!st.isEmpty()&& ch==str.charAt(1)&& st.peek()==str.charAt(0)){
            st.pop();
        }else{
            st.push(ch);
        }
       }
       StringBuilder result= new StringBuilder();
       while(!st.isEmpty()){
            result.append(st.pop());
       }
       return result.reverse().toString();

    }
}
