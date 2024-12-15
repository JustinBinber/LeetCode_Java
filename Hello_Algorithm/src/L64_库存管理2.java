public class L64_库存管理2 {
    class Solution {
        public int inventoryManagement(int[] stock) {
            int many = stock[0], many_count = 0, other_count = 0;
            for(int i = 0; i < stock.length; i++){
                if(many == stock[i]){
                    many_count++;
                }
                else {
                    other_count++;
                }
                if(many_count == other_count){
                    many = stock[i + 1];
                    many_count = 0;
                    other_count = 0;
                }
            }
            return many;
        }
    }
}
