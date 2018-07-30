package graph.dijkstra.better;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<String, Set<Edge>> graph = new HashMap<>();

    public void add(String vertex, int weight, String tailVertex) {
        Set<Edge> edges = graph.get(vertex);
        if (edges == null) {
            edges = new HashSet<>();
            graph.put(vertex, edges);
        }
        edges.add(Edge.builder().weight(weight).tail(tailVertex).build());
    }

    public Set<String> vertexs() {
        return graph.keySet();
    }

    public static Graph generateGraph() {
        Graph g = new Graph();
        g.add("a", 1, "b");
        g.add("a", 10, "f");
        g.add("b", 20, "f");
        g.add("b", 9, "c");
        g.add("b", 3, "e");
        g.add("c", 30, "d");
        g.add("c", 50, "e");
        g.add("d", 10, "e");
        g.add("f", 10, "c");
        g.add("f", 50, "d");
        g.add("e");
        return g;
    }

    private void add(String vertex) {
        Set<Edge> edges = graph.get(vertex);
        if (edges == null) {
            edges = new HashSet<>();
            graph.put(vertex, edges);
        }
    }

    public Set<Edge> getEdge(String vertex) {
        return graph.get(vertex);
    }
}
