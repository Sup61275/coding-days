class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character>st= new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty()&& ch=='*'){
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