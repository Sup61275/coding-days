class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(result.length());
            } else if (ch == ')') {
                int start = st.pop();
                reverse(result, start, result.length() - 1);
            } else {
                result.append(ch);
            }
        }  
        return result.toString();  
    }
    void reverse(StringBuilder s, int start, int end) {
        int left = start, right = end;
        while (left < right) { 
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
