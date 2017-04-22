package Contests.WeekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpanningTreeFraction {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nandm = toIntArray(br.readLine().split(" "));
        int n = nandm[0];
        int m = nandm[1];

        IGraph<Integer, Pair> graph = new Graph<>();
        graph.setUndirectedGraph();
        for (int i = 0; i < n; i++) {
            graph.addVertex(Integer.toString(i));
        }

        for (int i = 0; i < m; i++) {
            int[] uvab = toIntArray(br.readLine().split(" "));
            if (uvab[0] != uvab[1]) {
                graph.addEdge(uvab[0] + "", uvab[1] + "", new Pair(uvab[2], uvab[3]));
            }
        }

//        for (IGraph.Edge<Pair> edge: graph.getEdges()){
//            System.out.print(edge.edgeData.toString());
//        }
//        System.out.println();

        IGraph<Integer, Pair> mst = Kruscal(graph);

        int aSum = 0, bSum = 0;
        for (IGraph.Edge<Pair> edge : mst.getEdges()) {
//            System.out.println(edge.edgeData.toString());
            aSum += edge.getEdgeData().A;
            bSum += edge.getEdgeData().B;
        }

//        System.out.println(aSum + " " + bSum);
        System.out.println(asFraction(aSum, bSum));
    }


    private static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    private static String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }


    private static <V, E extends IWeight> IGraph<V, E> Kruscal(IGraph<V, E> g) {
        IGraph<V, E> mst = new Graph<>();
        mst.setUndirectedGraph();

        for (IGraph.Vertex<V> vertex : g.getVertices()) {
            mst.addVertex(vertex.getVertexName(), vertex.getVertexData());
        }

        List<IGraph.Edge<E>> allEdges = g.getEdges();

        allEdges.sort(new EdgeComparator<>());

//        for (IGraph.Edge<E> edge: allEdges){
//            System.out.print(((Pair) edge.getEdgeData()).toString());
//        }
//        System.out.println();

        int edgeCounter = 0, i = 0;
        int numVertices = g.getVertices().size();

        Map<String, SubGraph<V>> subGraphMap = new HashMap<>();

        //Construct subTrees for each vertex
        for (IGraph.Vertex<V> vertex : g.getVertices()) {
            SubGraph<V> subGraph = new SubGraph<>();
            subGraph.parent = vertex;
            subGraph.rank = 0;
            subGraphMap.put(vertex.getVertexName(), subGraph);
        }

        //Iteratively add new edges to the tree, ensuring no cycle is created
        //Ensures we only add as many edges as are necessary
        while (edgeCounter < numVertices - 1 && i < allEdges.size()) {
            IGraph.Edge<E> nextEdge = allEdges.get(i);

            IGraph.Vertex<V> fromRoot = findRootAndCollapse(subGraphMap, g.getVertex(nextEdge.getVertexName1()));
            IGraph.Vertex<V> toRoot = findRootAndCollapse(subGraphMap, g.getVertex(nextEdge.getVertexName2()));

            //Vertices on either side of the edge are not in the same subtree
            if (!fromRoot.equals(toRoot)) {
                //Add them to our running tree and union their subtrees
                mst.addEdge(nextEdge.getVertexName1(), nextEdge.getVertexName2(), nextEdge.getEdgeData());
                edgeCounter++;
                union(subGraphMap, fromRoot, toRoot);
            }

            i++;
        }

        return mst;
    }


    private static <V> IGraph.Vertex<V> findRootAndCollapse(Map<String, SubGraph<V>> subGraphs, IGraph.Vertex<V> vertex) {
        String vertexName = vertex.getVertexName();

        if (!subGraphs.get(vertexName).parent.equals(vertex)) {
            subGraphs.get(vertexName).parent = findRootAndCollapse(subGraphs, subGraphs.get(vertexName).parent);
        }

        return subGraphs.get(vertexName).parent;
    }

    //Merge two subtrees together based on larger rank, i.e. levels
    private static <V> void union(Map<String, SubGraph<V>> subGraphs, IGraph.Vertex<V> thing1, IGraph.Vertex<V> thing2) {
        IGraph.Vertex<V> firstRoot = findRootAndCollapse(subGraphs, thing1);
        IGraph.Vertex<V> secondRoot = findRootAndCollapse(subGraphs, thing2);
        String firstName = firstRoot.getVertexName();
        String secondName = secondRoot.getVertexName();

        if (subGraphs.get(firstName).rank < subGraphs.get(secondName).rank) {
            subGraphs.get(firstName).parent = secondRoot;
        } else if (subGraphs.get(firstName).rank > subGraphs.get(secondName).rank) {
            subGraphs.get(secondName).parent = firstRoot;
        } else {
            subGraphs.get(secondName).parent = firstRoot;
            subGraphs.get(firstName).rank++;
        }
    }


    private static class SubGraph<V> {
        IGraph.Vertex<V> parent;
        int rank;
    }

    //Comparator for IWeight classes
    static class EdgeComparator<E extends IWeight> implements Comparator<IGraph.Edge<E>> {
        @Override
        public int compare(IGraph.Edge<E> o1, IGraph.Edge<E> o2) {
            if (o1.edgeData.getWeight() >= 1.0 || o2.edgeData.getWeight() >= 1.0) {
                if (o1.getEdgeData().getWeight() > o2.getEdgeData().getWeight()) return -1;
                if (o1.getEdgeData().getWeight() < o2.getEdgeData().getWeight()) return 1;

                if (o1.edgeData.getWeight() == 1.0){
                    if (((Pair) o1.edgeData).A <= ((Pair) o2.edgeData).B){
                        return -1;
                    }
                    return 1;
                }

                if (((Pair) o1.edgeData).A >= ((Pair) o2.edgeData).B) return -1;
                return 1;
            }

            Pair o1Data = (Pair) o1.edgeData;
            Pair o2Data = (Pair) o2.edgeData;
            double ab1diff = o1Data.A - o1Data.B;
            double ab2diff = o2Data.A - o2Data.B;
            if (ab1diff > ab2diff) return -1;
            if (ab2diff > ab1diff) return 1;
            return o1Data.A > o2Data.A ? 1 : -1;
        }
    }


    public interface IWeight {
        double getWeight();
    }


    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    public static class Pair implements IWeight {
        double A, B;

        Pair(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public double getWeight() {
            return A / B;
        }

        @Override
        public String toString() {
            return Double.toString(A) + " " + Double.toString(B) + " : ";
        }
    }


    /**
     * Generic Graph implementation. Flexible between either directed or un-directed
     *
     * @param <V> Internal Vertex Data Type
     * @param <E> Internal Edge Data Type
     */
    public static class Graph<V, E> implements IGraph<V, E> {

        //Maps Vertex names to all outgoing edges
        private Map<String, List<Edge<E>>> nameToNeighbors = new HashMap<>();
        //Maps Vertex names to the actual vertex object
        private Map<String, Vertex<V>> nameToVertex = new HashMap<>();
        //Whether the graph is directed or not
        //Defaults to true, as the user must specify with set(Un)DirectedGraph()
        private boolean isDirected = true;

        /**
         * Default Constructor
         */
        Graph() {
        }

        /**
         * All undirected graphs are already directed, so only a flag switch is needed
         */
        @Override
        public void setDirectedGraph() {
            isDirected = true;
        }

        /**
         * To make undirected, we check all edges and add their converse, i.e. add (y,x) if (x,y) exists.
         * We do this without adding duplicates.
         */
        @Override
        public void setUndirectedGraph() {
            for (String vertex : nameToNeighbors.keySet()) {
                for (Edge<E> edge : nameToNeighbors.get(vertex)) {
                    putEdgeNoException(edge.getVertexName2(), vertex, edge.getEdgeData());
                }
            }
            isDirected = false;
        }

        //If the edge is present, simply return. Else, add the edge
        private void putEdgeNoException(String vertex1, String vertex2, E edgeData) {
            List<Edge<E>> edges = nameToNeighbors.get(vertex1);
            for (Edge<E> edge : edges) {
                if (edge.getVertexName2().equals(vertex2) && (edge.getEdgeData() == null || edge.getEdgeData().equals(edgeData))) {
                    return;
                }
            }
            edges.add(new Edge<>(vertex1, vertex2, edgeData));
        }

        /**
         * Simple getter
         */
        @Override
        public boolean isDirectedGraph() {
            return isDirected;
        }

        /**
         * Adds a vertex with the given name and no internal data
         *
         * @param vertexName The unique name of the vertex.
         * @throws DuplicateVertexException Thrown if the vertex already exists
         */
        @Override
        public void addVertex(String vertexName) throws DuplicateVertexException {
            putVertex(vertexName, null);
        }

        /**
         * Similar to the above function, only with (hopefully) non-null data
         *
         * @param vertexName The name of the new vertex
         * @param vertexData It's internal data
         * @throws DuplicateVertexException Thrown if vertex already exists
         */
        @Override
        public void addVertex(String vertexName, V vertexData) throws DuplicateVertexException {
            putVertex(vertexName, vertexData);
        }

        //Helper function for addVertex() methods. Performs duplicate check and adds new vertices
        private void putVertex(String vertexName, V vertexData) {
            if (containsVertex(vertexName)) throw new DuplicateVertexException();

            Vertex<V> v = new Vertex<>(vertexName, vertexData);
            nameToVertex.put(vertexName, v);
            nameToNeighbors.put(vertexName, new ArrayList<>());
        }

        //Simple contains check used for duplicate Vertex checks
        private boolean containsVertex(String vertexName) {
            return nameToVertex.keySet().contains(vertexName);
        }

        /**
         * Similar to addVertex(), only for edges.
         *
         * @param vertex1 The first vertex in the edge.
         * @param vertex2 The second vertex in the edge.
         * @throws DuplicateEdgeException Thrown if edge already exists
         * @throws NoSuchVertexException  Thrown if either vertex is not in the graph
         */
        @Override
        public void addEdge(String vertex1, String vertex2) throws DuplicateEdgeException, NoSuchVertexException {
            putEdge(vertex1, vertex2, null);
        }

        /**
         * Similar to the above function, only with (hopefully) non-null data
         *
         * @param vertex1  The first vertex in the edge.
         * @param vertex2  The second vertex in the edge.
         * @param edgeData The generic edge data.
         * @throws DuplicateEdgeException Thrown if the edge already exists
         * @throws NoSuchVertexException  Thrown if either vertex is not in the graph
         */
        @Override
        public void addEdge(String vertex1, String vertex2, E edgeData) throws DuplicateEdgeException, NoSuchVertexException {
            putEdge(vertex1, vertex2, edgeData);
        }

        //Helper method for addEdge() functions. Adds vertices and accounts for un-directed adds to the graph
        private void putEdge(String vertex1, String vertex2, E edgeData) {
            if (!(containsVertex(vertex1) && containsVertex(vertex2))) throw new NoSuchVertexException();

//            for (Edge<E> edge : nameToNeighbors.get(vertex1)) {
//                if (edge.getVertexName2().equals(vertex2)) {
//                    throw new DuplicateEdgeException();
//                }
//            }
//            if (!isDirected) {
//                for (Edge<E> edge : nameToNeighbors.get(vertex2)) {
//                    if (edge.getVertexName2().equals(vertex1)) {
//                        throw new DuplicateEdgeException();
//                    }
//                }
//            }

            List<Edge<E>> v1Edges = nameToNeighbors.get(vertex1);
            v1Edges.add(new Edge<>(vertex1, vertex2, edgeData));

            if (!isDirected) {
                List<Edge<E>> v2Edges = nameToNeighbors.get(vertex2);
                v2Edges.add(new Edge<>(vertex2, vertex1, edgeData));
            }
        }

        /**
         * Retrieves a vertex's internal data
         *
         * @param vertexName Name of vertex to get data for
         * @return Internal vertex data
         * @throws NoSuchVertexException Thrown if vertex is not in the graph
         */
        @Override
        public V getVertexData(String vertexName) throws NoSuchVertexException {
            if (!containsVertex(vertexName)) throw new NoSuchVertexException();
            return nameToVertex.get(vertexName).getVertexData();
        }

        /**
         * Overwrites or places a new vertex in the graph with updated data, as vertices are immutable
         *
         * @param vertexName The name of the vertex.
         * @param vertexData The generic vertex data.
         * @throws NoSuchVertexException Thrown if vertex is not in graph
         */
        @Override
        public void setVertexData(String vertexName, V vertexData) throws NoSuchVertexException {
            if (!containsVertex(vertexName)) throw new NoSuchVertexException();
            nameToVertex.put(vertexName, new Vertex<>(vertexName, vertexData));
        }

        /**
         * Retrieves the generic internal edge data
         *
         * @param vertex1 Vertex one of the edge.
         * @param vertex2 Vertex two of the edge.
         * @return The edge's data if present
         * @throws NoSuchVertexException Thrown if either vertex is not present
         * @throws NoSuchEdgeException   Thrown if no edge exists from vertex1 to 2
         */
        @Override
        public E getEdgeData(String vertex1, String vertex2) throws NoSuchVertexException, NoSuchEdgeException {
            if (!(containsVertex(vertex1) && containsVertex(vertex2))) throw new NoSuchVertexException();

            for (Edge<E> edge : nameToNeighbors.get(vertex1)) {
                if (edge.getVertexName2().equals(vertex2)) {
                    return edge.getEdgeData();
                }
            }
            throw new NoSuchEdgeException();
        }

        /**
         * Overwrites an edge's internal data
         *
         * @param vertex1  Vertex one of the edge.
         * @param vertex2  Vertex two of the edge.
         * @param edgeData The generic edge data.
         * @throws NoSuchVertexException Thrown if either vertex is not present
         * @throws NoSuchEdgeException   Thrown if the edge is not already in the graph
         */
        @Override
        public void setEdgeData(String vertex1, String vertex2, E edgeData) throws NoSuchVertexException, NoSuchEdgeException {
            if (!(containsVertex(vertex1) && containsVertex(vertex2))) throw new NoSuchVertexException();

            boolean isSet = setEdge(vertex1, vertex2, edgeData);
            if (!isSet) throw new NoSuchEdgeException();

            if (!isDirected) {
                isSet = setEdge(vertex2, vertex1, edgeData);
                if (!isSet) throw new NoSuchEdgeException();
            }
        }

        //Helper method for setEdgeData() that returns the truthity of its ability to overwrite an edge
        private boolean setEdge(String first, String second, E edgeData) {
            List<Edge<E>> edges = nameToNeighbors.get(first);
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).getVertexName2().equals(second)) {
                    Edge<E> edge = new Edge<>(first, second, edgeData);
                    edges.set(i, edge);
                    return true;
                }
            }
            return false;
        }

        /**
         * Simple retrieval for a vertex
         *
         * @param VertexName The name of the vertex.
         * @return The vertex associated with the name
         */
        @Override
        public Vertex<V> getVertex(String VertexName) throws NoSuchVertexException {
            if (!nameToVertex.containsKey(VertexName)) throw new NoSuchVertexException();
            return nameToVertex.get(VertexName);
        }

        /**
         * Simple edge retrieval with possible no such edge.
         * User assumes a directed edge from vertex1 to vertex2 exists
         *
         * @param vertexName1 Vertex one of edge.
         * @param vertexName2 Vertex two of edge.
         * @return The edge
         */
        @Override
        public Edge<E> getEdge(String vertexName1, String vertexName2) throws NoSuchEdgeException {
            for (Edge<E> edge : nameToNeighbors.get(vertexName1)) {
                if (edge.getVertexName2().equals(vertexName2)) {
                    return edge;
                }
            }
            throw new NoSuchEdgeException();
        }

        /**
         * @return A copy of all vertices in the graph
         */
        @Override
        public List<Vertex<V>> getVertices() {
            return new ArrayList<>(nameToVertex.values());
        }

        /**
         * If directed, simply add all edges to a list
         * Else, add edges but check for duplicates
         * <p>
         * IMPORTANT: INTERNALLY, UNDIRECTED GRAPHS REFLECT THE JAVADOC FOR setUndirectedGraph()
         * EDGE (X,Y) IS IN THE GRAPH IFF EDGE (Y,X) IS IN THE GRAPH
         * THUS, WE HAVE TO ENSURE WE RETURN ONLY THE RELEVANT EDGES
         *
         * @return A list of all edges in the graph
         */
        @Override
        public List<Edge<E>> getEdges() {
            List<Edge<E>> edges = new ArrayList<>();

            if (isDirected) {
                nameToNeighbors.values()
                        .forEach(list -> list.forEach(edges::add));
            } else {
                Set<NamePair> seen = new HashSet<>();
                for (List<Edge<E>> neighborList : nameToNeighbors.values()) {
                    for (Edge<E> edge : neighborList) {
                        NamePair pair = new NamePair(edge.getVertexName1(), edge.getVertexName2());
                        if (!seen.contains(pair)) {
                            edges.add(edge);
                        }
                        seen.add(pair);
                    }
                }
            }

            return edges;
        }

        //Used for getEdges() when graph is undirected to avoid an n^2 solution
        private class NamePair implements Map.Entry<String, String> {
            String vertex1, vertex2;

            NamePair(String v1, String v2) {
                vertex1 = v1;
                vertex2 = v2;
            }

            @Override
            public String getKey() {
                return vertex1;
            }

            @Override
            public String getValue() {
                return vertex2;
            }

            @Override
            public String setValue(String value) {
                return vertex2 = value;
            }

            @Override
            public int hashCode() {
                return vertex2.hashCode() + vertex1.hashCode();
            }

            @Override
            public boolean equals(Object other) {
                if (other.getClass().equals(NamePair.class)) {
                    NamePair o = (NamePair) other;
                    return o.vertex1.equals(vertex2) && o.vertex2.equals(vertex1) || vertex1.equals(o.vertex1) && vertex2.equals(o.vertex2);
                }
                return false;
            }
        }

        /**
         * @param vertex The vertex to return neighbors for.
         * @return A list of all vertices adjacent to the given vertex
         */
        @Override
        public List<Vertex<V>> getNeighbors(String vertex) {
            List<Vertex<V>> neighbors = new ArrayList<>();
            nameToNeighbors.get(vertex).forEach(neighborName ->
                    neighbors.add(nameToVertex.get(neighborName.getVertexName2()))
            );
            return neighbors;
        }
    }

    public interface IGraph<V, E> {
        /**
         * Set the graph to be a directed graph.  Edge (x, y) is different than edge (y, x)
         */
        public void setDirectedGraph();


        /**
         * Set the graph to be an undirected graph.  Edge (x, y) is in the graph
         * if and only if edge (y, x) is in the graph.  Note that when implementing this
         * and there are already edges defined in the graph, care must be taken to
         * resolve conflicts and inconsistencies in the overall implementation.
         */
        public void setUndirectedGraph();


        /**
         * @return true if the graph is directed.
         */
        public boolean isDirectedGraph();

        /**
         * Adds a vertex to the graph with name given by the vertexName.  vertexNames,
         * must be unique in the graph.
         *
         * @param vertexName The unique name of the vertex.
         * @throws IGraph.DuplicateVertexException
         */
        public void addVertex(String vertexName) throws DuplicateVertexException;


        /**
         * Adds a vertex to the graph with name given by the vertexName.  vertexNames,
         * must be unique in the graph.  The vertexData of generic type is associated with
         * this vertex.
         *
         * @param vertexName
         * @param vertexData
         * @throws IGraph.DuplicateVertexException
         */
        public void addVertex(String vertexName, V vertexData) throws DuplicateVertexException;


        /**
         * Adds an edge to the graph by specifying the two vertices that comprise the
         * edge.  If the graph is undirected then edge (x, y) or edge (y, x) may be used
         * to add the single edge.  If the graph is undirected and edge (x,y) is added
         * followed by a subsequent edge (y, x), the later add would throw a
         * DuplicateEdgeException.
         *
         * @param vertex1 The first vertex in the edge.
         * @param vertex2 The second vertex in the edge.
         * @throws IGraph.DuplicateEdgeException
         * @throws IGraph.NoSuchVertexException
         */
        public void addEdge(String vertex1, String vertex2) throws DuplicateEdgeException, NoSuchVertexException;


        /**
         * Adds an edge to the graph by specifying the two vertices that comprise the
         * edge.  If the graph is undirected then edge (x, y) or edge (y, x) may be used
         * to add the single edge.  If the graph is undirected and edge (x,y) is added
         * followed by a subsequent edge (y, x), the later add would throw a
         * DuplicateEdgeException.  The edgeDaa parameter is used to associate generic
         * edge data with the edge.
         *
         * @param vertex1  The first vertex in the edge.
         * @param vertex2  The second vertex in the edge.
         * @param edgeData Thegeneric edge data.
         * @throws IGraph.DuplicateEdgeException
         * @throws IGraph.NoSuchVertexException
         */
        public void addEdge(String vertex1, String vertex2, E edgeData) throws DuplicateEdgeException, NoSuchVertexException;


        /**
         * Returns the generic vertex data associated with the specified vertex.  If no
         * vertex data is associated with the vertex, then null is returned.
         *
         * @param vertexName Name of vertex to get data for
         * @return The generic vertex data
         * @throws IGraph.NoSuchVertexException
         */
        public V getVertexData(String vertexName) throws NoSuchVertexException;


        /**
         * Sets the generic vertex data of the specified vertex.
         *
         * @param vertexName The name of the vertex.
         * @param vertexData The generic vertex data.
         * @throws IGraph.NoSuchVertexException
         */
        public void setVertexData(String vertexName, V vertexData) throws NoSuchVertexException;


        /**
         * Returns the generic edge data associated with the specified edge.  If no
         * edge data is associated with the edge, then null is returned.
         *
         * @param vertex1 Vertex one of the edge.
         * @param vertex2 Vertex two of the edge.
         * @return The generic edge data.
         * @throws IGraph.NoSuchVertexException
         * @throws IGraph.NoSuchEdgeException
         */
        public E getEdgeData(String vertex1, String vertex2) throws NoSuchVertexException, NoSuchEdgeException;


        /**
         * Sets the generic edge data of the specified edge.
         *
         * @param vertex1  Vertex one of the edge.
         * @param vertex2  Vertex two of the edge.
         * @param edgeData The generic edge data.
         * @throws IGraph.NoSuchVertexException
         * @throws IGraph.NoSuchEdgeException
         */
        public void setEdgeData(String vertex1, String vertex2, E edgeData) throws NoSuchVertexException, NoSuchEdgeException;

        /**
         * Returns an encapsulated Vertex data type based on the vertex name
         *
         * @param VertexName The name of the vertex.
         * @return The encapsulated vertex.
         */
        public Vertex<V> getVertex(String VertexName);


        /**
         * Returns an encapsulated Edge data type based on the specified edge.
         *
         * @param vertexName1 Vertex one of edge.
         * @param vertexName2 Vertex two of edge.
         * @return Encapsulated edge.
         */
        public Edge<E> getEdge(String vertexName1, String vertexName2);

        /**
         * Returns a list of all the vertices in the graph.
         *
         * @return The List<Vertex> of vertices.
         */
        public List<Vertex<V>> getVertices();

        /**
         * Returns all the edges in the graph.
         *
         * @return The List<Edge<E>> of edges.
         */
        public List<Edge<E>> getEdges();

        /**
         * Returns all the neighbors of a specified vertex.
         *
         * @param vertex The vertex to return neighbors for.
         * @return The list of vertices that are the neighbors of the specified vertex.
         */
        public List<Vertex<V>> getNeighbors(String vertex);


        /**
         * This class represents a vertex.  Do not change this class or this interface.
         *
         * @param <V>
         */
        public static final class Vertex<V> {
            private final String vertex;
            private final V vertexData;

            public Vertex(String v, V d) {
                vertex = v;
                vertexData = d;
            }

            public String getVertexName() {
                return vertex;
            }

            public V getVertexData() {
                return vertexData;
            }

            @Override
            public int hashCode() {
                int hash = 3;
                hash = 23 * hash + Objects.hashCode(this.vertex);
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final Vertex<?> other = (Vertex<?>) obj;
                return Objects.equals(this.vertex, other.vertex);
            }
        }


        /**
         * This class represents an edge.  Do not change this class or interface.
         *
         * @param <E>
         */
        public static final class Edge<E> {
            private final String vertex1;
            private final String vertex2;
            public final E edgeData;

            public Edge(String v1, String v2, E ed) {
                vertex1 = v1;
                vertex2 = v2;
                edgeData = ed;
            }

            public String getVertexName1() {
                return vertex1;
            }

            public String getVertexName2() {
                return vertex2;
            }

            public E getEdgeData() {
                return edgeData;
            }


            @Override
            public int hashCode() {
                int hash = 7;
                hash = 59 * hash + Objects.hashCode(this.vertex1);
                hash = 59 * hash + Objects.hashCode(this.vertex2);
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final Edge<?> other = (Edge<?>) obj;
                if (!Objects.equals(this.vertex1, other.vertex1)) {
                    return false;
                }
                return Objects.equals(this.vertex2, other.vertex2);
            }
        }

        // Exceptions used in the interface.

        public final static class DuplicateVertexException extends RuntimeException {
        }

        public final static class DuplicateEdgeException extends RuntimeException {
        }

        public final static class NoSuchVertexException extends RuntimeException {
        }

        public final static class NoSuchEdgeException extends RuntimeException {
        }
    }
}
