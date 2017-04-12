package ProjectEuler;

/**
 * Created by Adam on 3/22/2017.
 */
public class LargestPalindome {
    public static void main(String[] args) {
        int largest = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                if (Integer.toString(i * j).equals(new StringBuilder(Integer.toString(i * j)).reverse().toString())){
                    largest = Math.max(i * j, largest);
                }
            }
        }

        System.out.println(largest);
    }
}
