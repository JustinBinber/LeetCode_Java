import java.util.Collections;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> objects = new LinkedList<>();
        Collections.addAll(objects, 5, 4, 3, 2, 1);
        //objects.sort(Integer::compare);
        objects.sort((x, y) -> {
            return -x + y;
        });
        System.out.println(objects);
    }
}
