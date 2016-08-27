package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 8/11/2016.
 */
public class NewPrimsST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandm = toIntArray(br.readLine().split(" "));
        int n = nandm[0];
        int m = nandm[1];

        @SuppressWarnings("unchecked")
        List<Edge>[] adjacencyList = new ArrayList[n];
        Node[] graph = new Node[n];
        int[][] edges = new int[n][n];
        for (int[] edge : edges) {
            Arrays.fill(edge, Integer.MAX_VALUE);
        }
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node(i);
        }
        for (int i = 0; i < adjacencyList.length; i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] xyr = toIntArray(br.readLine().split(" "));
            int x = xyr[0] - 1;
            int y = xyr[1] - 1;
            int r = xyr[2];

            if (x != y && r < edges[x][y]) {
                edges[x][y] = r;
                edges[y][x] = r;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (edges[i][j] != Integer.MAX_VALUE) {
                    adjacencyList[i].add(new Edge(i, edges[i][j], j));
                }
            }
        }

        int source = Integer.parseInt(br.readLine()) - 1;
//        int mstSize = naivePrimsAlgo(graph, adjacencyList, source, edges);
        int size = primsAlgo(graph, adjacencyList, source);
        System.out.println(size);
//        System.out.println(mstSize);
    }

    private static int naivePrimsAlgo(Node[] graph, List<Edge>[] adjacencyList, int source, int[][] edges){
        boolean[] visited = new boolean[graph.length];
        Node sourceNode = graph[source];
        sourceNode.distance = 0;
        visited[sourceNode.index] = true;

        Set<Integer> mstIndicies = new HashSet<>();
        mstIndicies.add(sourceNode.index);

        for (Edge neighbor: adjacencyList[source]){
            graph[neighbor.toIndex].distance = neighbor.weight;
        }
        Edge nextNeighbor = nextNeighbor(visited, mstIndicies, adjacencyList);
        while (nextNeighbor != null){
            graph[nextNeighbor.toIndex].distance = Math.min(graph[nextNeighbor.toIndex].distance, edges[nextNeighbor.fromIndex][nextNeighbor.toIndex]);
            visited[nextNeighbor.toIndex] = true;
            mstIndicies.add(nextNeighbor.toIndex);
            nextNeighbor = nextNeighbor(visited, mstIndicies, adjacencyList);
        }

        int total = 0;
        for (Node n: graph){
            total += n.distance;
        }
        return total;
    }

    private static Edge nextNeighbor(boolean[] visited, Set<Integer> mstIndicies, List<Edge>[] adjacencyList){
        int min = Integer.MAX_VALUE;
        Edge toReturn = null;
        for (int index: mstIndicies){
            for (Edge edge: adjacencyList[index]){
                if (!visited[edge.toIndex] && edge.weight < min){
                    min = edge.weight;
                    toReturn = edge;
                }
            }
        }
        return toReturn;
    }

    private static int primsAlgo(Node[] graph, List<Edge>[] adjacencyList, int source) {
        boolean[] visited = new boolean[graph.length];
        Node sourcenode = graph[source];
        sourcenode.distance = 0;
        Heap heap = new Heap();
//        heap.insert(sourcenode);

        for (Edge edge: adjacencyList[source]){
            graph[edge.toIndex].distance = edge.weight;
        }

        Arrays.stream(graph).forEach(heap::insert);

        while (!heap.isEmpty()) {
            Node n = heap.extract();
            visited[n.index] = true;
            for (Edge edge : adjacencyList[n.index]) {
                if (!visited[edge.toIndex]) {
                    Node neighbor = graph[edge.toIndex];
                    heap.remove(neighbor);
                    neighbor.distance = Math.min(neighbor.distance, edge.weight);
                    heap.insert(neighbor);
                }
            }
        }

        final int[] total = {0};
        Arrays.stream(graph).forEach(node -> total[0] += node.distance);
        return total[0];
    }

    private static int[] toIntArray(String[] arr) {
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    private static class Heap {
        private List<Node> heap;

        Heap() {
            heap = new ArrayList<>();
        }

        boolean isEmpty() {
            return heap.size() == 0;
        }

        int size() {
            return heap.size();
        }

        void heapifyUp(Node n) {
            heapifyUp(heap.indexOf(n));
        }

        void heapifyUp(int index) {
            Node current = heap.get(index);
            int parentIndex = index / 2;
            Node parent = heap.get(parentIndex);
            while (index > 0 && current.compareTo(parent) == -1) {
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = index / 2;
                current = heap.get(index);
                parent = heap.get(parentIndex);
            }
        }

        void insert(Node n) {
            if (heap.contains(n)) return;
            heap.add(n);
            heapifyUp(heap.size() - 1);
        }

        void remove(Node n) {
            if (heap.contains(n)) {
                int index = heap.indexOf(n);
                if (index == heap.size() - 1) {
                    heap.remove(index);
                    return;
                }
                swap(heap.size() - 1, index);
                heap.remove(heap.size() - 1);

                heapifyDown(index);
            }
        }

        Node extract() {
            if (heap.size() == 1) {
                return heap.remove(0);
            }

            Node toReturn = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);

            heapifyDown(0);
            return toReturn;
        }

        void heapifyDown(int index) {
            int minChildIndex = minChildIndex(index);
            while (minChildIndex != -1) {
                swap(minChildIndex, index);
                index = minChildIndex;
                minChildIndex = minChildIndex(index);
            }
        }

        private int minChildIndex(int index) {
            Node bubbler = heap.get(index);
            boolean leftChild = 2 * index < heap.size();
            boolean rightChild = 2 * index + 1 < heap.size();

            if (leftChild && rightChild) {
                int compareLeft = bubbler.compareTo(heap.get(2 * index));
                int compareRight = bubbler.compareTo(heap.get(2 * index + 1));
                if (compareLeft <= 0 && compareRight <= 0) {
                    return -1;
                }
                Node left = heap.get(2 * index);
                Node right = heap.get(2 * index + 1);
                return left.compareTo(right) == -1 ? 2 * index : 2 * index + 1;
            } else if (leftChild) {
                if (bubbler.compareTo(heap.get(2 * index)) <= 0) {
                    return -1;
                }
                return 2 * index;
            }
            return -1;
        }

        void swap(int i, int j) {
            Node temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    private static class Edge {
        int fromIndex, weight, toIndex;

        Edge(int f, int w, int t) {
            fromIndex = f;
            weight = w;
            toIndex = t;
        }
    }

    private static class Node implements Comparable<Node> {
        int index;
        int distance;

        Node(int index) {
            this.index = index;
            this.distance = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Node o) {
            if (distance < o.distance) {
                return -1;
            }
            if (distance > o.distance) {
                return 1;
            }
            return 0;
        }
    }
}
