package HackerRankAlgorithms.GraphTheory;

import java.io.*;
import java.util.*;

/**
 * Created by Adam on 7/7/2016.
 */
public class SimplestDijkstraAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int[] nandm = toIntArray(br.readLine().split(" "));
            int numNodes = nandm[0];
            int numEdges = nandm[1];

            @SuppressWarnings("unchecked")
            List<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[numNodes + 1];
            for (int k = 0; k < graph.length; k++){
                graph[k] = new ArrayList<>();
            }
            int[][] edges = new int[numNodes + 1][numNodes + 1];

            for (int j = 0; j < numEdges; j++){
                int[] xyr = toIntArray(br.readLine().split(" "));
                int x = xyr[0];
                int y = xyr[1];
                int r = xyr[2];

                if (edges[x][y] > r || edges[x][y] == 0){
                    edges[x][y] = r;
                    edges[y][x] = r;

                    if (!graph[x].contains(y)){
                        graph[x].add(y);
                        graph[y].add(x);
                    }
                }
            }
            int source = Integer.parseInt(br.readLine());
            smartDijkstrasAlgo(graph, edges, source);
//            int[] shortestDistances = dijkstrasAlgo(graph, edges, source);
//            print(shortestDistances);
//            printToGEXF(graph, edges, numEdges);
        }
    }

    /**
     * Find the index of the closest node we haven't "visited" yet
     * In the first iteration, this means the source node, as it is closest to itself
     *
     * Visit it then iterate over its neighbors
     * If the distance to the neighbor is less than what we had previously thought/recorded, overwrite it
     *
     * The outer for loop guarantees that all nodes will be counted as visited exactly once
     */
    private static void smartDijkstrasAlgo(List<Integer>[] graph, int[][] edges, int source){
        long[] dist = new long[graph.length];
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[source] = 0L;
        for (int i = 1; i <= graph.length - 1; i++){
            int u = minDist(dist, visited);
            visited[u] = true;
            if (graph[u].size() > 0){
                for (int neighbor: graph[u]){
                    int weight = edges[u][neighbor];
                    if (!visited[neighbor] && dist[u] + weight < dist[neighbor]){
                        dist[neighbor] = dist[u] + weight;
                    }
                }
            }
        }
        print(dist, source);
    }

    private static int minDist(long[] dist, boolean[] visited){
        long min = Long.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i < dist.length; i++){
            if (!visited[i] && dist[i] < min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void print(long[] dist, int source){
        for (int i = 1; i < dist.length; i++){
            if (dist[i] == Long.MAX_VALUE){
                System.out.print(-1 + " ");
            }
            else if (i != source){
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    private static void printToGEXF(List<Integer>[] graph, int[][] edges, int numEdges) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("C:/Users/Adam/Desktop/graph.gexf");
        printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        printWriter.println("<gexf xmlns:viz=\"http:///www.gexf.net/1.1draft/viz\" version=\"1.1\" xmlns=\"http://www.gexf.net/1.1draft\">\n");
        printWriter.println("<graph defaultedgetype=\"undirected\" idtype=\"string\" type=\"static\">");
        printWriter.println("<nodes count=\"" + graph.length + "\">");

        for (int i = 1; i < graph.length; i++){
            printWriter.println("<node id=\"" + i + "\" label=\"" + i + "\"/>");
        }
        printWriter.println("</nodes>");

        printWriter.println("<edges count=\"" + numEdges + "\">");
        int counter = 0;
        for (int i = 1; i < graph.length; i++){
            for (int j: graph[i]){
                printWriter.println("<edge id=\"" + counter++ + "\" source=\"" + i + "\" target=\"" + j + "\" label=\"" + edges[i][j] + "\"/>");
            }
        }
        printWriter.println("</edges>");
        printWriter.println("</graph>");
        printWriter.println("</gexf>");
        printWriter.close();
    }

    private static void print(int[] arr){
        for (int i: arr){
            if (i > 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void printGraph(List<Integer>[] graph, int[][] edges){
        for (int i = 0; i < graph.length; i++){
            System.out.println(i + ": ");
            for (int j: graph[i]){
                System.out.println("Distance to " + j + " is " + edges[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] dijkstrasAlgo(List<Integer>[] graph, int[][] edges, int source){
        boolean[] visited = new boolean[graph.length];
        int[] shortestDistances = new int[graph.length];
        Arrays.fill(visited, false);
        Arrays.fill(shortestDistances, -1);

        Queue<Integer> queue = new PriorityQueue<>();
        shortestDistances[source] = 0;
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()){
            int n = queue.poll();
            visited[n] = true;
            for (int neighbor: graph[n]){
                if (!visited[neighbor]){
                    int distance = shortestDistances[n] + edges[n][neighbor];
                    if (shortestDistances[neighbor] == -1){
                        shortestDistances[neighbor] = distance;
                    }
                    else{
                        shortestDistances[neighbor] = Math.min(shortestDistances[neighbor], distance);
                    }
                    if (!queue.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
        }

        return shortestDistances;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
