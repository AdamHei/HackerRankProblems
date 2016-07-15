package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 7/9/2016.
 */
public class HeapDijkstrasAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int[] nandm = toIntArray(br.readLine().split(" "));
            int numNodes = nandm[0];
            int numEdges = nandm[1];

            Graph graph = new Graph(numNodes + 1);

            int[][] edges = new int[numNodes + 1][numNodes + 1];
            for (int[] edge : edges) {
                Arrays.fill(edge, Integer.MAX_VALUE);
            }

            for (int j = 0; j < numEdges; j++){
                int[] xyr = toIntArray(br.readLine().split(" "));
                int x = xyr[0];
                int y = xyr[1];
                int r = xyr[2];

                if (r < edges[x][y]){
                    edges[x][y] = r;
                    edges[y][x] = r;
                }
            }

            int source = Integer.parseInt(br.readLine());

            for (int m = 0; m < edges.length; m++){
                for (int l = 0; l < edges.length; l++){
                    if (edges[l][m] != Integer.MAX_VALUE){
                        graph.addEdge(l, m, edges[l][m]);
                    }
                }
            }

            dijkstrasAlgo(graph, source);
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    private static void dijkstrasAlgo(Graph graph, int sourceIndex){
        Node source = graph.vertices[sourceIndex];
        boolean[] visited = new boolean[graph.size];
        Heap heap = new Heap();
        heap.insert(source);
        source.distance = 0;

        while (!heap.isEmpty()){
            Node n = heap.extract();
            visited[n.index] = true;
            for (Neighbor neighbor: n.neighbors){
                if (!visited[neighbor.index]){
                    heap.insert(graph.vertices[neighbor.index]);
                }
                if (graph.vertices[neighbor.index].distance > n.distance + neighbor.weight){
                    graph.vertices[neighbor.index].distance = n.distance + neighbor.weight;
                    heap.heapifyUp(graph.vertices[neighbor.index]);
                }
            }
        }

        for (int i = 1; i < graph.vertices.length; i++){
            if (graph.vertices[i].distance == Integer.MAX_VALUE){
                System.out.print("-1 ");
            }
            else if (i != sourceIndex){
                System.out.print(graph.vertices[i].distance + " ");
            }
        }
        System.out.println();
    }

    private static class Heap{
        private List<Node> heap;

        Heap(){
            heap = new ArrayList<>();
        }

        boolean isEmpty() {
            return heap.size() == 0;
        }

        void heapifyUp(Node n){
            for (int i = 0; i < heap.size(); i++){
                if (heap.get(i).index == n.index){
                    heapifyUp(i);
                    return;
                }
            }
        }

        void heapifyUp(int i){
            int index = i;
            Node current = heap.get(index);
            int parentIndex = index / 2;
            Node parent = heap.get(parentIndex);
            while (index > 0 && current.compareTo(parent) == -1){
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = index / 2;
                current = heap.get(index);
                parent = heap.get(parentIndex);
            }
        }

        void insert(Node n){
            /*
             * This check just saved my heap implementation
             */
            if (heap.contains(n)){
                return;
            }

            heap.add(n);
            int index = heap.size() - 1;
            int parentIndex = index / 2;
            while (index > 0 && n.compareTo(heap.get(parentIndex)) == -1){
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = index / 2;
            }
        }

        Node extract() {
            if (heap.size() == 1){
                return heap.remove(0);
            }

            Node toReturn = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);

            int index = 0;
            int minChildIndex = minChildIndex(index);
            while (minChildIndex != -1){
                swap(minChildIndex, index);
                index = minChildIndex;
                minChildIndex = minChildIndex(index);
            }

            return toReturn;
        }

        private int minChildIndex(int i){
            Node bubbler = heap.get(i);
            boolean leftChild = 2 * i < heap.size();
            boolean rightChild = 2 * i + 1 < heap.size();

            if (leftChild && rightChild){
                int compareLeft = bubbler.compareTo(heap.get(2 * i));
                int compareRight = bubbler.compareTo(heap.get(2 * i + 1));
                if (compareLeft <= 0 && compareRight <= 0){
                    return -1;
                }
                Node left = heap.get(2 * i);
                Node right = heap.get(2 * i + 1);
                return left.compareTo(right) == -1 ? 2 * i : 2 * i + 1;
            }
            else if (leftChild){
                if (bubbler.compareTo(heap.get(2 * i)) <= 0){
                    return -1;
                }
                return 2 * i;
            }
            else{
                return -1;
            }
        }

        void swap(int parent, int index){
            Node temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);
        }
    }

    private static class Graph{
        Node[] vertices;
        int size;

        Graph(int size){
            this.size = size;
            vertices = new Node[size];
            for (int i = 0; i < size; i++){
                vertices[i] = new Node(i);
            }
        }

        void addEdge(int x, int y, int w){
            vertices[x].neighbors.add(new Neighbor(y, w));
//            vertices[y].neighbors.add(new Neighbor(x, w));
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        List<Neighbor> neighbors;
        int distance;

        Node(int index){
            this.index = index;
            distance = Integer.MAX_VALUE;
            neighbors = new ArrayList<>();
        }

        @Override
        public int compareTo(Node o) {
            if (distance < o.distance){
                return -1;
            }
            else if (distance > o.distance){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    private static class Neighbor{
        int index;
        int weight;

        Neighbor(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }
}
