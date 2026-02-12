package DSA.Strings;

/*
question:

You are given a string s consisting of lowercase English letters.
A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
Return the length of the longest balanced substring of s.

=====================================================

notes:

this finds the longest substring where all distinct characters appear the same number of times. 
for every starting index i, it expands the substring forward and keeps track of character frequencies using a size-26 array. 
distinct counts how many different characters are present, and freq keeps track of the maximum frequency among them.

the key observation is: a substring is balanced if
    distinct * freq == length of substring
because if all characters appear equally, and there are distinct characters each appearing freq times,
then total length must be distinct * freq.

so during expansion, whenever this condition holds, that substring is balanced and maxLen is updated.
this runs in O(n^2) time since all substrings are explored, but checking balance is O(1).
*/


public class LongestBalancedSubstring {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++) {
            int arr[] = new int[26];
            int distinct = 0;
            int freq = 0;

            for(int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                int length = j-i+1;

                if(arr[idx] == 0) distinct++;
                arr[idx]++;

                freq = Math.max(freq, arr[idx]);

                if(distinct*freq == length) {
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        return maxLen;
    }
}

