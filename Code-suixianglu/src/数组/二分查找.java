package 数组;

/**
 * @author: yangjiabin
 * @date: 2025/2/26 10:35
 * @desc:
 */
public class 二分查找 {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            int mid = (left + right) / 2;
            while (left <= right && left <= nums.length - 1 && right >= 0){
                if (target > nums[mid]){
                    left = mid + 1;
                    mid = (left + right) / 2;
                }
                else if (target < nums[mid]){
                    right = mid - 1;
                    mid = (left + right) / 2;
                }
                else {
                    return mid;
                }
            }
            return -1;
        }
    }

}
