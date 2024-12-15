public class L63_训练计划6 {
    class Solution {
        public int trainingPlan(int[] actions) {
            int [] tem = new int[32];
            int ans = 0;
            for (int i = 0; i < actions.length; i++){
                for (int j = 31; j >= 0; j--){
                    tem[j] += actions[i] & 1;
                    actions[i]  = actions[i] >> 1;
                }
            }
            for (int i = 0; i <= 31; i++){
                ans = ans << 1;
                tem[i] = tem[i] % 3;
                ans = ans | tem[i];
            }
            return ans;
        }
    }
}
