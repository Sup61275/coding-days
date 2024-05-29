class Solution {
    //First sliding window question
    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxVowels(String s, int k) {
        int i = 0, j = 0;
        int maxVowCount = 0;
        int count = 0;

        while (j < s.length()) {
            // Add the vowel count of the new character in the window
            if (isVowel(s.charAt(j))) {
                count++;
            }

            // Check if the current window size is k, kyuki hme k size ka substring mai hi khojna hai
            if (j - i + 1 == k) {
                // Update the maximum vowel count found so far
                maxVowCount = Math.max(maxVowCount, count);

                // Remove the vowel count of the old character in the window
                //abi i ko bdha k window ko aage slide krna hai,so jo i ki value added thi ushko substract kren pdega.
                if (isVowel(s.charAt(i))) {
                    count--;
                }

                // Slide the window
                i++;
            }

            // Expand the window
            j++;
        }

        return maxVowCount;
    }
}
