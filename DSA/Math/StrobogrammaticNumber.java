package DSA.Math;

import java.util.*;

/*
notes:

this checks if a number is strobogrammatic, 
meaning it still looks valid when rotated 180 degrees. 

a hashmap stores valid digit rotations like 0→0, 1→1, 6→9, 8→8 and 9→6. 

two pointers are used from start and end of the string, 
and each pair is checked using the map to see if the rotation matches. 

if any digit doesn't exist in the map or the rotation doesn't match the opposite side, 
it's not strobogrammatic. 

if all pairs satisfy the mapping, the number is valid.
*/

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');

        int left = 0;
        int right = num.length()-1;

        while(left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);

            if(!map.containsKey(l) || map.get(l) != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
