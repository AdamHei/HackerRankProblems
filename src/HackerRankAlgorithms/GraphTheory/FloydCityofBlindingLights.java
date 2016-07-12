package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 7/11/2016.
 */
public class FloydCityofBlindingLights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandm = toIntArray(br.readLine().split(" "));
        int n = nandm[0];
        int m = nandm[1];

        double[][] dist = new double[n + 1][n + 1];
        for (double[] aDist : dist) {
            Arrays.fill(aDist, Double.POSITIVE_INFINITY);
        }
        for (int j = 0; j < dist.length; j++){
            dist[j][j] = 0;
        }

        for (int k = 0; k < m; k++){
            int[] edge = toIntArray(br.readLine().split(" "));
            dist[edge[0]][edge[1]] = edge[2];
        }

        for (int l = 0; l < dist.length; l++){
            for (int o = 0; o < dist.length; o++){
                for (int p = 0; p < dist.length; p++){
                    if (dist[o][p] > dist[o][l] + dist[l][p]){
                        dist[o][p] = dist[o][l] + dist[l][p];
                    }
                }
            }
        }

        int cases = Integer.parseInt(br.readLine());

        for (int q = 1; q <= cases; q++){
            int[] pair = toIntArray(br.readLine().split(" "));
            int a = pair[0];
            int b = pair[1];

            if (dist[a][b] == Double.POSITIVE_INFINITY){
                System.out.println(-1);
            }
            else{
                System.out.println((int) dist[a][b]);
            }
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
