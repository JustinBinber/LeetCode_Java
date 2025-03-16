package 哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class L383_赎金信 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<String, Integer> hashMap1 = new HashMap<>();
            HashMap<String, Integer> hashMap2 = new HashMap<>();

            for (int i = 0; i <= ransomNote.length() - 1; i++) {
                String s = String.valueOf(ransomNote.charAt(i));
                hashMap1.put(s,hashMap1.getOrDefault(s, 0) + 1);
            }

            for (int i = 0; i <= magazine.length() - 1; i++) {
                String s = String.valueOf(magazine.charAt(i));
                hashMap2.put(s,hashMap2.getOrDefault(s, 0) + 1);
            }

            Set<Map.Entry<String, Integer>> entries = hashMap1.entrySet();
            for (Map.Entry<String, Integer> entry : entries){
                String key = entry.getKey();
                if (hashMap2.containsKey(key) && entry.getValue() <= hashMap2.get(key)) continue;
                return false;
            }
            return true;
        }
    }
}
