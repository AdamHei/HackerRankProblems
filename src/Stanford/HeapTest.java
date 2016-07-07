package Stanford;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Adam on 7/6/2016.
 */
public class HeapTest {
    public static void main(String[] args) {
        int[] arr = new int[500];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(1000);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Heap heap = new Heap(arr);

        Arrays.sort(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();

        while (!heap.isEmpty()){
            System.out.print(heap.extract() + " ");
        }
    }
}
