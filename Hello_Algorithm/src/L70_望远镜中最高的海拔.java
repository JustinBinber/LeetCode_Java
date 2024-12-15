import java.util.ArrayDeque;
import java.util.Deque;

public class L70_望远镜中最高的海拔 {
    class Solution {
        public int[] maxAltitude(int[] heights, int limit) {
            int left = 0, right = 0;
            int[] ans = new int[heights.length - limit + 1];
            //ArrayList arrayList = new ArrayList();
            Deque<Integer> stack = new ArrayDeque<>();
            if (heights.length == 0) return new int[0];

            while (right < limit){
                while (!stack.isEmpty() && heights[right] >= stack.getLast()){
                    stack.pollLast();
                }
                stack.addLast(heights[right]);
                right++;
            }
            ans[left] = stack.peekFirst();

            while (left < heights.length - limit) {

                if (heights[left] == stack.getFirst()){
                    stack.pollFirst();
                }
                while (!stack.isEmpty() && heights[right] > stack.getLast()){
                    stack.pollLast();
                }
                stack.addLast(heights[right]);
                left++;
                ans[left] = stack.peekFirst();
                right++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        L70_望远镜中最高的海拔 out = new L70_望远镜中最高的海拔();
        L70_望远镜中最高的海拔.Solution solution = out.new Solution();
        int[] heights = new int[]{14,2,27};
        int[] ans = solution.maxAltitude(heights, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
