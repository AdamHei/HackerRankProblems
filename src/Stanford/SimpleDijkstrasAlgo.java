package Stanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 6/25/2016.
 */
public class SimpleDijkstrasAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++){
            int[] nandm = toIntArray(br.readLine().split(" "));
            Graph graph = new Graph(nandm[0] + 1);
            for (int j = 0; j < nandm[1]; j++){
                int[] edge = toIntArray(br.readLine().split(" "));
                graph.addEdge(edge[0], edge[1], edge[2]);
            }
            int source = Integer.parseInt(br.readLine());
//            graph.printGraph();
            int[] shortest = dijkstrasAlgo(graph, source);
//            print(shortest);
        }
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
//            if (arr[i] != 0)
                System.out.print(arr[i] + " ");
        }
//        for (int i: arr){
//            if (i != 0)
//                System.out.print(i + " ");
//        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    private static int[] dijkstrasAlgo(Graph graph, int source){
        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        graph.get(source).shortestDistance = 0;
        queue.add(graph.get(source));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.index] = true;
            for (Edge edge: node.getNeighbors()){
                Node neighbor = graph.get(edge.neighbor);
                if (!visited[neighbor.index]){
                    int distance = node.shortestDistance + edge.weight;
                    neighbor.shortestDistance = Math.min(neighbor.shortestDistance, distance);
                    if (!queue.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
        }

        int[] shortestDistance = new int[graph.size()];
        for (int i = 0; i < shortestDistance.length; i++){
            if (graph.get(i).shortestDistance == Integer.MAX_VALUE){
                shortestDistance[i] = -1;
            }
            else{
                shortestDistance[i] = graph.get(i).shortestDistance;
            }
        }
        return shortestDistance;
    }

    private static class Graph{
        private List<Node> nodes;

        Graph(int maxSize){
            nodes = new ArrayList<>();
            for (int i = 0; i < maxSize; i++)
                nodes.add(new Node(i));
        }

        Node get(int index) { return nodes.get(index); }
        int size(){return nodes.size();}

        void addEdge(int from, int to, int weight){
            Node a = nodes.get(from);
            Node b = nodes.get(to);

            a.addEdge(to, weight);
            b.addEdge(from, weight);
        }

        void printGraph(){
            for (Node node: nodes){
                System.out.print(node.getIndex() + ":::: ");
                for (Edge edge: node.getNeighbors()){
                    System.out.print("(neighbor: " + edge.neighbor + ", weight: " + edge.weight + "), ");
                }
                System.out.println();
            }
        }
    }

    static class Node implements Comparable<Node>{
        int shortestDistance;
        private Map<Integer, Edge> neighbors;
        private int index;

        Node(int index){
            this.index = index;
            neighbors = new HashMap<>();
            shortestDistance = Integer.MAX_VALUE;
        }

        void addEdge(int neighbor, int weight){
            if (neighbors.containsKey(neighbor)){
                Edge edge = neighbors.get(neighbor);
                if (weight < edge.weight){
                    System.out.println("Replacing edge from " + index + " to " + neighbor + " with weight " + edge.weight + " to new weight of " + weight);
                    edge.weight = weight;
                }
            }
            else{
                neighbors.put(neighbor, new Edge(neighbor, weight));
            }
        }

        Edge getEdge(int index){ return neighbors.get(index); }
        int getIndex(){ return index; }
        Collection<Edge> getNeighbors(){ return neighbors.values(); }

        @Override
        public int compareTo(Node other) {
            if (shortestDistance < other.shortestDistance)
                return -1;
            else if (shortestDistance == other.shortestDistance)
                return 0;
            else
                return 1;
        }
    }

    private static class Edge{
        int neighbor;
        int weight;
        Edge(int neighbor, int weight)
        {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }
}
