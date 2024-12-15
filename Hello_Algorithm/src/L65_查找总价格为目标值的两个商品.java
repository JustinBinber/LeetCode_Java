public class L65_查找总价格为目标值的两个商品 {
    class Solution {
        public int[] twoSum(int[] price, int target) {
            int midoftarget = target / 2;
            int left = 0, right = price.length - 1, middle = (left + right);
            int[] res = new int[2];
            while (left != right - 1) {
                if(price[middle] > midoftarget) {
                    right = middle;
                }
                else if(price[middle] <= midoftarget) {
                    left = middle;
                }
                middle = (left + right) / 2;
            }

            while (left >= 0 && right < price.length) {
                if (price[left] + price[right] > target) {
                    left --;
                } else if (price[left] + price[right] < target) {
                    right ++;
                }
                else {
                    res[0] = price[left];
                    res[1] = price[right];
                    break;
                }

            }
            return res;

        }
    }

    public static void main(String[] args) {
        L65_查找总价格为目标值的两个商品 outer = new L65_查找总价格为目标值的两个商品();
        L65_查找总价格为目标值的两个商品.Solution solution = outer.new Solution();
        int[] res = solution.twoSum(new int[]{8, 21, 27, 34, 52, 66 }, 61);
        System.out.println(res[0] + " " + res[1]);
    }
}
/*
一个数一定可以分解为两个数，其中一个小于等于他的一半，一个数大于等于他的一半
首先找到一半这个分界线，x为小于分界线的，y为大于分界线的
 */