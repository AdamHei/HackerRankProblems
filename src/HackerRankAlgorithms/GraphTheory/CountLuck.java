package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 7/16/2016.
 */
public class CountLuck {

    private static int correctCount;
    private static boolean[][] visited;
    private static int runningCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int[] nandm = toIntArray(br.readLine().split(" "));

            char[][] forest = new char[nandm[0]][nandm[1]];
            for (int j = 0; j < forest.length; j++){
                forest[j] = br.readLine().toCharArray();
            }

            correctCount = 0;
            runningCount = 0;
            visited = new boolean[nandm[0]][nandm[1]];

            int[] ronAndHermoine = new int[2];
            for (int j = 0; j < forest.length; j++){
                for (int k = 0; k < forest[0].length; k++){
                    if (forest[j][k] == 'M'){
                        ronAndHermoine = new int[]{j, k};
                        break;
                    }
                }
            }

            int k = Integer.parseInt(br.readLine());
            visited[ronAndHermoine[0]][ronAndHermoine[1]] = true;
            dfs(forest, ronAndHermoine[0], ronAndHermoine[1]);

            System.out.println(correctCount == k ? "Impressed" : "Oops!");
        }
    }

    private static void dfs(char[][] forest, int i, int j){
        if (forest[i][j] == '*'){
            correctCount = runningCount;
        }
        List<int[]> goodEdges = goodEdges(forest, i, j);
        if (goodEdges.size() > 1){
            runningCount++;
        }
        for (int[] edge: goodEdges){
            dfs(forest, edge[0], edge[1]);
        }
        if (goodEdges.size() > 1){
            runningCount--;
        }
    }

    private static List<int[]> goodEdges(char[][] forest, int i, int j){
        List<int[]> edges = new ArrayList<>();

        if (i - 1 >= 0 && !visited[i - 1][j] && (forest[i - 1][j] == '.' || forest[i - 1][j] == '*')){
            visited[i - 1][j] = true;
            edges.add(new int[]{i - 1, j});
        }
        if (i + 1 < forest.length && !visited[i + 1][j] && (forest[i + 1][j] == '.' || forest[i + 1][j] == '*')){
            visited[i + 1][j] = true;
            edges.add(new int[]{i + 1, j});
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && (forest[i][j - 1] == '.' || forest[i][j - 1] == '*')){
            visited[i][j - 1] = true;
            edges.add(new int[]{i, j - 1});
        }
        if (j + 1 < forest[0].length && !visited[i][j + 1] && (forest[i][j + 1] == '.' || forest[i][j + 1] == '*')){
            visited[i][j + 1] = true;
            edges.add(new int[]{i, j + 1});
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
