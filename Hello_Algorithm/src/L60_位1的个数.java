public class L60_位1的个数 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int tem = 0, sum = 0;
            while (n != 0){
                tem = n & 1;
                sum += tem;
                n = n >>> 1;
            }
            return sum;
        }
    }

}
