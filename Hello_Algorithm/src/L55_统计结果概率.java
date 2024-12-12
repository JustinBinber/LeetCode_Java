import java.util.Arrays;

public class L55_统计结果概率 {
    class Solution {
        double[] a = {1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6};
        double[] b = {1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6};
        public double[] statisticsProbability(int num) {
            double[] probabilities = new double[6 + (num - 1) * 5];
            double[] a = {1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6};
            //double[] b = {1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6};
            return digui(a, b,num);

        }
        public double[] digui(double[] probabilities, double[] newshaizi, int num) {
            if (num == 2){
                double[] tem = new double[probabilities.length + 5];
                for (int i = 0; i < newshaizi.length; i++) {
                    for (int j = 0; j < probabilities.length; j++) {
                        tem[j + i] += newshaizi[i] * probabilities[j];
                    }
                }
                return tem;
            }
            else if (num == 1){
             return a;
            }
            else {
                probabilities = digui(probabilities, newshaizi, num - 1);

                double[] tem = new double[probabilities.length + 5];
                for (int i = 0; i < newshaizi.length; i++) {
                    for (int j = 0; j < probabilities.length; j++) {
                        tem[j + i] += newshaizi[i] * probabilities[j];
                    }
                }
                return tem;
            }
        }
    }

    public static void main(String[] args) {
        L55_统计结果概率 outer = new L55_统计结果概率();
        Solution s = outer.new Solution();
        double[] probabilities = s.statisticsProbability(2);
        System.out.println(Arrays.toString(probabilities));

    }
}