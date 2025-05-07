package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: yangjiabin
 * @date: 2025/5/2 12:21
 * @desc: 思路 从0位置开始找所有的回文
 *          每次找的时候遍历，从当前位置开始，到后面的每个位置是不是回文
 *          如果是回文则加入tem，继续从新的位置找回文，最后左指针到最后的位置则结束
 *          不是回文则跳过
 */
public class L131_分割回文串 {
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        Deque<String> tem = new ArrayDeque<>();
        public List<List<String>> partition(String s) {
            recur(s, 0);
            return ans;
        }

        public void recur(String s, int left){
            if (left == s.length()){
                ans.add(new ArrayList<>(tem));
                return;
            }

            for (int i = left; i <= s.length() - 1; i++) {
                if (!isHuiWen(s, left, i + 1)) continue;

                tem.add(s.substring(left, i + 1));
                recur(s, i + 1);
                tem.pollLast();
            }
        }


        // 左闭区右开
        public boolean isHuiWen(String s, int left, int right){
            // [0,1) 包含长度为1 、包含偶数个字符
            int len = right - left;
            if (len / 2 == 0){
                for (int i = left; i < len / 2 + left; i++) {
                    if (s.charAt(i) != s.charAt(right - i - 1 + left)) return false;
                }
            } else {
                for (int i = left; i < len / 2 + left; i++) {
                    if (s.charAt(i) != s.charAt(right - i - 1 + left)) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        L131_分割回文串 l131_分割回文串 = new L131_分割回文串();
        Solution solution = l131_分割回文串.new Solution();
        solution.partition(new String("aab"));
    }
}
