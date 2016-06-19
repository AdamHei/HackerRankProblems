package HackerRankAlgorithms.Search;

/**
 * Created by Adam on 6/15/2016.
 */
public class MaximizeSum {

    static int[][] memoization;

    public static void main(String[] args) {

    }

    private static int contig(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            for (int j = arr.length - 1; j >= i; j--){
                int sum = sumFrom(arr, i, j);
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private static int sumFrom(int[] arr, int i, int j){
        if (memoization[i][j] != Integer.MIN_VALUE){
            return memoization[i][j];
        }
        int sum = 0;
        for (int temp = i; temp <= j; temp++){
            if (memoization[temp][j] != Integer.MIN_VALUE){
                sum += memoization[temp][j];
                temp = j + 1;
            }
            else{
                memoization[i][temp] = (sum += arr[temp]);
            }
        }
        memoization[i][j] = sum;
        return sum;
    }
}
