class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int count = 0;

while (i < s.length() && j < t.length()) {
    if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
    } else if (s.charAt(i) != t.charAt(j)) {
        i++;
    }
    if (i == s.length()  && j < t.length()) {
        count = t.length() - j;
    }
        }

        return count;
    }
}