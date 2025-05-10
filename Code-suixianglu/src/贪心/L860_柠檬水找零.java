package 贪心;

public class L860_柠檬水找零 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] charge = new int[3];
            for (int i = 0; i <= bills.length - 1; i++) {
                if (bills[i] == 5) charge[0]++;
                else if (bills[i] == 10) {
                    if (charge[0] > 0){
                        charge[0]--;
                        charge[1]++;
                    }
                    else return false;
                }
                else {
                    if (charge[1] > 0 && charge[0] >0){
                        charge[1]--;
                        charge[0]--;
                    }
                    else if (charge[0] >= 3){
                        charge[0] = charge[0] - 3;
                    }
                    else return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        L860_柠檬水找零 l860_柠檬水找零 = new L860_柠檬水找零();
        Solution solution = l860_柠檬水找零.new Solution();
        solution.lemonadeChange(new int[]{5,5,10,10,20});
    }
}
