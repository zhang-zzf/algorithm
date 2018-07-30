package graph.dijkstra.better;

import java.util.*;

public class DijkstraAlgorithm {

    public static int dijkstra(Graph graph, String startVertex, String stopVertex) {
        Set<String> handledVertex = new HashSet<>();
        Map<String, Integer> vertexWeight = new HashMap<>();
        Map<String, String> parentVertex = new HashMap<>();

        // 初始化权重
        for (String v : graph.vertexs()) {
            int weight = Integer.MAX_VALUE;
            if (v.equals(startVertex)) {
                weight = 0;
            }
            vertexWeight.put(v, weight);
        }

        // 必须遍历所有vertex
        for (String minWeightVertex = getMinWeightVertex(vertexWeight, handledVertex);
             minWeightVertex != null; minWeightVertex = getMinWeightVertex(vertexWeight, handledVertex)) {

            int minWeight = vertexWeight.get(minWeightVertex);
            Set<Edge> neighbors = graph.getEdge(minWeightVertex);
            for (Edge e : neighbors) {
                String vertex = e.getTail();
                int w = e.getWeight() + minWeight;
                if (w < vertexWeight.get(vertex)) {
                    // 更新权重
                    vertexWeight.put(vertex, w);
                    // 更新parent
                    parentVertex.put(vertex, minWeightVertex);
                }
            }
            handledVertex.add(minWeightVertex);
        }

        System.out.println(vertexWeight);
        System.out.println(generatePath(parentVertex, stopVertex));
        return vertexWeight.get(stopVertex);
    }

    private static Collection generatePath(Map<String, String> parentVertex, String stopVertex) {
        Deque<String> ret = new LinkedList<>();
        for (String vertex = stopVertex; vertex != null; vertex = parentVertex.get(vertex)) {
            ret.addFirst(vertex);
        }
        return ret;
    }

    private static String getMinWeightVertex(Map<String, Integer> vertexWeight, Set<String> handledVertex) {
        String minWeightVertex = null;
        int minWeight = Integer.MAX_VALUE;
        Iterator<Map.Entry<String, Integer>> it = vertexWeight.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            String v = next.getKey();
            if (handledVertex.contains(v)) {
                continue;
            }
            if (next.getValue() < minWeight) {
                minWeight = next.getValue();
                minWeightVertex = v;
            }
        }
        return minWeightVertex;
    }
}
