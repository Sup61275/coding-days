class Solution {
    public char findTheDifference(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s.length(); i++) {
            sum1 += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum2 += t.charAt(i);
        }
        
      
        int asciiValue = sum2 - sum1;
        char character = (char) (asciiValue);
        
        return character;
    }
}
