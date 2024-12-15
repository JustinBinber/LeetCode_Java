public class L67_砍竹子2 {
    class Solution {
        public int cuttingBamboo(int bamboo_len) {
            int yushu, num_3, mod = 1000000007;
            long x = 3, ans = 1;
            if (bamboo_len <= 3) return bamboo_len - 1;
            yushu = bamboo_len % 3;
            num_3 = bamboo_len / 3 - 1;
            while (num_3 > 0){
                if (num_3 % 2 != 0) ans = ((x * ans) % mod);
                x = x * x % mod;
                // 这里不能用math的平方，因为返回的是double类型，转换成整形会损失精度
                num_3 = num_3 / 2;
            }
            if (yushu == 1) return (int) (ans * 4 % mod);
            else if (yushu == 0) return (int) (ans * 3 % mod);
            else return (int) (ans * 6 % mod);
        }
    }
}
