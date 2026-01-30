package DSA.Strings;

/*
notes:

this finds the longest palindromic substring by expanding around centers. 
every index is treated as a possible center, and two cases are checked: 
odd length palindromes (single center) and even length palindromes (two centers). this is done in the j loop.

for each center, pointers expand left and right as long as characters match. 
whenever a longer palindrome is found, its start and end are updated. 
this avoids checking all substrings directly and works in O(n^2) time with O(1) extra space.
*/

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        int start = 0;
        int end = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) { 
                int low = i;
                int high = i + j;

                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    if (high - low + 1 > maxLen) {
                        maxLen = high - low + 1;
                        start = low;
                        end = high;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
