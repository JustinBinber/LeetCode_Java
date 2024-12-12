public class L62_撞色搭配 {
    class Solution {
        public int[] sockCollocation(int[] sockets) {
            int[] ans = new int[2];
            int yihuo = 0, right_one, yihuo_two = 0;
            for (int i = 0; i <= sockets.length - 1; i++){
                yihuo = yihuo ^ sockets[i];
            }
            right_one = yihuo & (~(yihuo - 1));
            for (int i = 0; i <= sockets.length - 1; i++){
                if ((right_one & sockets[i]) == 0){
                    yihuo_two = yihuo_two ^ sockets[i];
                }
            }
            ans[0] = yihuo_two;
            ans[1] = yihuo ^ yihuo_two;
            return ans;

        }
    }
    public static void main(String[] args) {
        L62_撞色搭配 out = new L62_撞色搭配();
        L62_撞色搭配.Solution s = out.new Solution();
        int[] tem = {4,5,2,4,6,6};
        int[] ans = s.sockCollocation(tem);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}

