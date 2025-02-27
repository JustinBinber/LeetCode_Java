package 数组;

public class L27_移除元素 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int loc = 0;
            int i = nums.length - 1;
            while (loc <= nums.length - 1 && loc <= i){
                if (loc == i){
                    if (nums[loc] == val){
                        return loc;
                    }
                    else return loc + 1;
                }

                if (nums[loc] != val){
                    loc++;
                    continue;
                }

                while (i >= 0 && i >= loc){
                    if (nums[i] == val){
                        i--;
                    }
                    else {
                        nums[loc] = nums[i];
                        loc ++;
                        i--;
                        break;
                    }
                }
            }
            return loc;

        }
    }
}
