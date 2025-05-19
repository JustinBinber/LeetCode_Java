package 单调栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: yangjiabin
 * @date: 2025/5/19 17:48
 * @desc: 单调栈从栈顶到栈底是递减的，表示左边最近的最低点，当一个柱子比单调栈中的最高点还要高的时候，不断重复下面的计算：
 *              1.只考虑自己这根柱子的面积
 *              2.到左边第一个低点之间的最大面积（宽：右侧不动，左侧为目标较小值的左边最近的较小值（栈中的下一个元素） 高：目标较小值
 *              3.重复直到栈中没有更小值
 */
public class L84_柱状图中最大的矩形 {

    class Solution_ans {
        int largestRectangleArea(int[] heights) {
            Stack<Integer> st = new Stack<Integer>();

            // 数组扩容，在头和尾各加入一个元素
            int [] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;
            for (int index = 0; index < heights.length; index++){
                newHeights[index + 1] = heights[index];
            }

            heights = newHeights;

            st.push(0);
            int result = 0;
            // 第一个元素已经入栈，从下标1开始
            for (int i = 1; i < heights.length; i++) {
                // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
                if (heights[i] > heights[st.peek()]) {
                    st.push(i);
                } else if (heights[i] == heights[st.peek()]) {
                    st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                    st.push(i);
                } else {
                    while (heights[i] < heights[st.peek()]) { // 注意是while
                        int mid = st.peek();
                        st.pop();
                        int left = st.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        result = Math.max(result, w * h);
                    }
                    st.push(i);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        L84_柱状图中最大的矩形 l84_柱状图中最大的矩形 = new L84_柱状图中最大的矩形();
        Solution_ans solution = l84_柱状图中最大的矩形.new Solution_ans();
        solution.largestRectangleArea(new int[]{1,1,1,2,3,1,1,2});
    }
}
