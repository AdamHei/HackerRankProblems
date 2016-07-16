package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 7/16/2016.
 */
public class ConnectedCellInAGrid {

    private static int runningCount;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int maxCount = 0;
        runningCount = 0;
        visited = new boolean[m][n];

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++){
            grid[i] = toIntArray(br.readLine().split(" "));
        }

        for (int j = 0; j < grid.length; j++){
            for (int k = 0; k < grid[0].length; k++){
                if (!visited[j][k] && grid[j][k] == 1){
                    runningCount++;
                    dfs(grid, j, k);
                    maxCount = Math.max(maxCount, runningCount);
                    runningCount = 0;
                }
            }
        }
        System.out.println(maxCount);
    }

    private static void dfs(int[][] grid, int i, int j){
        visited[i][j] = true;
        List<int[]> goodEdges = goodEdges(grid, i, j);
        for (int[] edge: goodEdges){
            runningCount++;
            dfs(grid, edge[0], edge[1]);
        }
    }

    private static List<int[]> goodEdges(int[][] grid, int i, int j){
        List<int[]> edges = new ArrayList<>();
        for (int k = -1; k <= 1; k++){
            for (int l = -1; l <= 1; l++){
                if (k != 0 || l != 0){
                    if (i + k >= 0 && i + k < grid.length && j + l >= 0 && j + l < grid[0].length){
                        if (!visited[i + k][j + l] && grid[i + k][j + l] == 1){
                            visited[i + k][j + l] = true;
                            edges.add(new int[]{i + k, j + l});
                        }
                    }
                }
            }
        }
        return edges;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
