package graph.dijkstra.feng;

import com.alibaba.fastjson.JSONObject;
import lombok.ToString;

import java.util.*;

@ToString
public class Graph {
    private Map<Vertex, Set<Edge>> graph = new HashMap<>();

    public void addVertex(Vertex vertex) {
        graph.putIfAbsent(vertex, new HashSet<Edge>());
    }

    public void addEdge(Vertex vertex, Edge edge) {
        Set<Edge> edges = graph.get(vertex);
        if (edges == null) {
            edges = new HashSet<>();
            graph.put(vertex, edges);
        }
        edges.add(edge);
    }

    public Set<Vertex> getVertexs() {
        return graph.keySet();
    }

    public boolean contains(Vertex vertex) {
        return graph.keySet().contains(vertex);
    }


    public Set<Edge> getEdge(Vertex vertex) {
        return graph.get(vertex);
    }
    public Vertex getVertex(String name) {
        Iterator<Vertex> it = graph.keySet().iterator();
        while (it.hasNext()) {
            Vertex v = it.next();
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex start = new Vertex("start");
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex stop = new Vertex("stop");

        g.addEdge(start, Edge.builder().next(A).weight(0).build());
        g.addEdge(start, Edge.builder().next(B).weight(5).build());
        g.addEdge(A, Edge.builder().next(C).weight(35).build());
        g.addEdge(A, Edge.builder().next(D).weight(30).build());
        g.addEdge(B, Edge.builder().next(C).weight(20).build());
        g.addEdge(B, Edge.builder().next(D).weight(15).build());
        g.addEdge(C, Edge.builder().next(stop).weight(10).build());
        g.addEdge(D, Edge.builder().next(stop).weight(20).build());

        System.out.println(JSONObject.toJSONString(g));

    }

    public static Graph generateGraph() {
        Graph g = new Graph();
        Vertex start = new Vertex("start");
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex stop = new Vertex("stop");

        g.addEdge(start, Edge.builder().next(A).weight(0).build());
        g.addEdge(start, Edge.builder().next(B).weight(5).build());
        g.addEdge(A, Edge.builder().next(C).weight(35).build());
        g.addEdge(A, Edge.builder().next(D).weight(30).build());
        g.addEdge(B, Edge.builder().next(C).weight(20).build());
        g.addEdge(B, Edge.builder().next(D).weight(15).build());
        g.addEdge(C, Edge.builder().next(stop).weight(10).build());
        g.addEdge(D, Edge.builder().next(stop).weight(20).build());
        g.addVertex(stop);
        return g;

    }
}
