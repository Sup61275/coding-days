class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        
        int oddCount = 0; 
        int palindromeLength = 0;
        
        
        for (int freq : charFreq.values()) {
            
            if (freq % 2 == 1) {
                oddCount++;
                palindromeLength += freq - 1;
            } else {
                
                palindromeLength += freq;
            }
        }
        if (oddCount > 0) {
            palindromeLength++;
        }
        
        return palindromeLength;
    }
}