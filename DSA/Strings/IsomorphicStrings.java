package DSA.Strings;

/*
notes:
this checks whether two strings are isomorphic, meaning characters from one string can be mapped to the other in a one-to-one way. 
two arrays are used to store the last seen position of each character in both strings. 
while iterating, if the last seen positions don’t match, the mapping is inconsistent and returns false. 
using i+1 avoids confusion with default zero values. overall this works in O(n) time with constant space.
*/

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] mapS = new int[200];
        int[] mapT = new int[200];

        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }

            mapS[s.charAt(i)] = i+1;
            mapT[t.charAt(i)] = i+1;
        }
        
        return true;
    }
}
