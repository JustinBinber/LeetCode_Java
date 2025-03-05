package 哈希表;

/**
 * @author: yangjiabin
 * @date: 2025/3/5 16:23
 * @desc:
 */

public class L242_有效的字母异位词 {

    class Solution {

    int[] char1 = new int[26];
    int[] char2 = new int[26];
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        for (int i = 0; i <= len1 - 1; i++){
            int i1 = Integer.parseInt(String.valueOf(s.charAt(i) - 'a'));
            char1[i1]++;
        }
        for (int i = 0; i <= len2 - 1; i++){
            int i2 = Integer.parseInt(String.valueOf(t.charAt(i) - 'a'));
            char2[i2]++;
        }
        for (int i = 0; i <= 25; i++){
            if (char1[i] != char2[i]) return false;
        }
        return true;


    }
}

}
