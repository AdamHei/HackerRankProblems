import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Adam on 6/12/2016.
 */
public class playground {

    public static void main(String[] args) throws IOException {

//        for (int i = 10; i < 50; i++) {
//            System.out.println(binarySearch(i) + " " + Math.sqrt(i));
//        }

//        int[] arr = {1,-1,2,-1,3,-1,4,-1,5,-1,6,-1,7,-1,-10};
//        System.out.println(LIS(arr));

        MAX = 4;
//        printCompositions(5, 0);
//        print(5, "");
//        newPrint(20, 0, new int[21], 0);
        print(5, "");
    }

    static int[] arr = new int[100];
    static int MAX;


    static void print(int n, String s){
        if (n <= 0){
            if (n == 0){
                System.out.println(s);
            }
        }
        else {
            for (int i = 1; i <= MAX; i++) {
                print(n - i, s + " " + i);
            }
        }
    }

    private static void printCompositions(int n, int i){
        if (n == 0){
            for (int j = 0; j < i; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
        else if (n > 0){
            for (int j = 1; j <= MAX; j++) {
                arr[i] = j;
                printCompositions(n - j, i + 1);
            }
        }
    }

    static int LIS(int[] arr){
        int[] subsequence = new int[arr.length];
        subsequence[0] = arr[0];
        int lastElement = 0;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < subsequence[0]) {
                subsequence[0] = arr[i];
            }
            else if (arr[i] > subsequence[lastElement]){
                lastElement++;
                subsequence[lastElement] = arr[i];
            }
            else {
                int toReplace = binarySearch(subsequence, arr[i], -1, lastElement);
                subsequence[toReplace] = arr[i];
            }
        }
        return lastElement + 1;
    }

    private static int binarySearch(int[] arr, int k, int left, int right){
        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] <= k){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }

    static int kadanesAlgo(int[] arr){
        int max_to_here = 0, max_so_far = 0;
        for (int i: arr){
            max_to_here = Math.max(max_to_here + i, 0);
            max_so_far = Math.max(max_to_here, max_so_far);
        }

        return max_so_far;
    }

    static double binarySearch(double d){
        double previousGuess = d / 2;

        double leftBound = 0, rightBound = d;

        for (int i = 0; i < 10000; i++) {
            double temp = previousGuess;
            previousGuess = (leftBound + rightBound) / 2;

            if (temp * temp > d) {
                rightBound = temp;
            }
            else {
                leftBound = temp;
            }
        }

        return previousGuess;
    }

    static double sqrt(double d){
        double previousX = d / 2;

        for (int i = 0; i < 100; i++) {
            previousX = .5 * (previousX + d / previousX);
        }

        return previousX;
    }
}
