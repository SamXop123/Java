package DSA.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
notes:
this sorts characters in a string based on their frequency using bucket sort. 
first a hashmap counts how many times each character appears and also tracks the maximum frequency. 
then an array of lists is used where index = frequency, so characters with same frequency go into the same bucket. 
finally buckets are read from high to low frequency and each character is appended frequency times to build the result string. 
this avoids sorting explicitly and runs in O(n).
*/


public class CharacterSortbyFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }

        List<Character>[] buckets = new List[max+1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
