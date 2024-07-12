import java.util.StringTokenizer;
class Solution {
    public String simplifyPath(String path) {
        String token;
        Stack<String> st = new Stack<>();
        StringTokenizer ss = new StringTokenizer(path, "/");

        while (ss.hasMoreTokens()) {
            token = ss.nextToken();
            if (token.equals("") || token.equals(".")) continue;

            if (!token.equals("..")) {
                st.push(token);
            } else if (!st.isEmpty()) {
                st.pop();
            }
        }

        String result = "";
        while (!st.isEmpty()) {
            result = "/" + st.pop() + result;
        }
        
        if (result.length() == 0) {
            result = "/";
        }

        return result;
    }
}