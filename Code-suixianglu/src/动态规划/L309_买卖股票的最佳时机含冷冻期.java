package 动态规划;

public class L309_买卖股票的最佳时机含冷冻期 {
    class Solution {
        public int maxProfit(int[] prices) {
           int chigu = - prices[0];
           int cold = 0;
           int noCold = 0;
            for (int i = 1; i <= prices.length - 1; i++) {
                int newcold = chigu + prices[i];
                int newchigu = Integer.max(chigu, noCold - prices[i]);
                int newnoCold = Integer.max(cold, noCold);
                cold = newcold;
                noCold = newnoCold;
                chigu = newchigu;
            }
            return Integer.max(Integer.max(chigu, cold), noCold);
        }
    }

    public static void main(String[] args) {
        L309_买卖股票的最佳时机含冷冻期 l309_买卖股票的最佳时机含冷冻期 = new L309_买卖股票的最佳时机含冷冻期();
        Solution solution = l309_买卖股票的最佳时机含冷冻期.new Solution();
        solution.maxProfit(new int[]{1,2,3,0,2});
    }
}
