import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Adam on 6/12/2016.
 */
public class playground {
    public static void main(String[] args) {
        ArrayList<Integer>[] lists = (ArrayList<Integer>[])new ArrayList[50];
        Arrays.fill(lists, new ArrayList<>());
        lists[0].add(5);
        System.out.println(lists[0].get(0));

    }
}
