class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int count = 0, max_count = 0;
        
        while (j < n) {
            char currentChar = s.charAt(j);
            if (!map.containsKey(currentChar) || map.get(currentChar) == 0) {
                map.put(currentChar, 1);
                count++;
            } else {
                while (map.containsKey(currentChar) && map.get(currentChar) > 0) {
                    char leftChar = s.charAt(i);
                    map.put(leftChar, map.get(leftChar) - 1);
                    i++;
                    count--;
                }
                map.put(currentChar, 1);
                count++;
            }
            max_count = Math.max(max_count, count);
            j++;
        }
        
        return max_count;
    }
}
