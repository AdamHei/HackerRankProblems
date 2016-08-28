import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by Adam on 6/12/2016.
 */
public class playground {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BitSet bitSet = new BitSet();
        bitSet.set(2);
        bitSet.set(0);
        BitSet bitSet1 = new BitSet();
        bitSet1.set(1);
        bitSet1.set(4);
        bitSet.or(bitSet1);
        bitSet.stream().forEach(System.out::print);
        System.out.println(bitSet.length());
        System.out.println(bitSet.stream().sum());
        System.out.println(bitSet.size());
    }

    private static int numCombos(int n){
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != 0) return memo[n];
        return memo[n] = numCombos(n -1) + numCombos(n - 2);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
