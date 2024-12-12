public class L61_加密运算 {
    class Solution {
        public int encryptionCalculate(int dataA, int dataB) {
            int jinwei = (dataA & dataB) << 1, xiangjia = dataA ^ dataB;
            int ans = xiangjia;
            while (jinwei != 0 ){
                ans = xiangjia ^ jinwei;
                jinwei = (xiangjia & jinwei) << 1;
                xiangjia = ans;
            }
        return ans;
        }
    }
}
