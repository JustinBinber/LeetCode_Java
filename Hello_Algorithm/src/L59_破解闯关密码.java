import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class L59_破解闯关密码 {
    class Solution {
        public class MyComparator implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {

                return  (o1 + o2).compareTo(o2 + o1);;
            }
        }
        public String crackPassword(int[] password) {
            List<String> list = new ArrayList<>();
            String ans = "";
            for (int i = 0; i < password.length; i++) {
                list.add(String.valueOf(password[i]));
            }
            list.sort(new MyComparator());
            for (int i = 0; i < list.size(); i++) {
                ans += list.get(i);
            }
            return ans;
        }
    }
}
