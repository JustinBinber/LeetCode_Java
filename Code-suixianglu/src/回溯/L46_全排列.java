package 回溯;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yangjiabin
 * @date: 2025/5/4 14:16
 * @desc: 方法1 通过哈希表记录所有用过的字符，每次遍历的时候都是完全遍历，但是会跳过使用过的字符
 *        方法2 首先复制一份nums，然后将用过的挪到前面一个区域的尾部
 */
public class L46_全排列 {
    class Solution1 {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        HashSet<Integer> hashSet = new HashSet<>();
        public List<List<Integer>> permute(int[] nums) {
            recur(nums);
            return ans;
        }

        public void recur(int[] nums){
            if (tem.size() == nums.length){
                ans.add(new ArrayList<>(tem));
                return;
            }

            for (int i = 0; i <= nums.length - 1; i++) {
                if (hashSet.contains(nums[i])) continue;
                tem.add(nums[i]);
                hashSet.add(nums[i]);
                recur(nums);
                hashSet.remove(nums[i]);
                tem.pollLast();
            }
        }
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            // 这样创建的是不可变的
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            recur(list, 0);
            return ans;
        }

        public void recur(List<Integer> list, int idxLeft){
            if (idxLeft == list.size()){
                ans.add(new ArrayList<>(list));
                return;
            }

            for (int i = idxLeft; i <= list.size() - 1; i++) {
                Collections.swap(list, idxLeft, i);
                recur(list, idxLeft + 1);
                Collections.swap(list, idxLeft, i);
            }
        }
    }

    public static void main(String[] args) {
        L46_全排列 l46_全排列 = new L46_全排列();
        Solution solution = l46_全排列.new Solution();
        solution.permute(new int[]{1,2,3});
    }
}
