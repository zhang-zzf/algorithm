package graph.dijkstra.feng;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

  public static List<Vertex> dijkstraGraph(Graph graph, Vertex start, Vertex stop) {
    Deque<Vertex> ret = new LinkedList<>();

    Map<Vertex, DVertex> dVertexMap = new HashMap<>();
    // 开始节点的最小权重为0
    dVertexMap.put(start, DVertex.builder().vertex(start).minWeight(0).build());
    for (Vertex v : graph.getVertexs()) {
      // 其它节点的最小权重为无限大
      dVertexMap.putIfAbsent(v, DVertex.builder().vertex(v).minWeight(Integer.MAX_VALUE).build());
    }

    for (Vertex v = getUnhandledMinWeightVertex(dVertexMap); v != null;
        v = getUnhandledMinWeightVertex(dVertexMap)) {
      Set<Edge> edges = graph.getEdge(v);
      Iterator<Edge> it = edges.iterator();
      while (it.hasNext()) {
        Edge edge = it.next();
        DVertex nextDVertex = dVertexMap.get(edge.getNext());
        int w = dVertexMap.get(v).getMinWeight() + edge.getWeight();
        if (w < nextDVertex.getMinWeight()) {
          nextDVertex.setMinWeight(w);
          nextDVertex.setPre(v);
        }
      }
      dVertexMap.get(v).setHandled(true);
    }

    DVertex dVertex = dVertexMap.get(stop);
    while (dVertex != null) {
      ret.addFirst(dVertex.getVertex());
      dVertex = dVertexMap.get(dVertex.getPre());
    }
    System.out.println(ret);
    return (List<Vertex>) ret;
  }

  private static Vertex getUnhandledMinWeightVertex(Map<Vertex, DVertex> dVertexMap) {
    DVertex minWeightDVertex = null;
    Iterator<Map.Entry<Vertex, DVertex>> it = dVertexMap.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Vertex, DVertex> next = it.next();
      DVertex d = next.getValue();
      if (d.isHandled()) {
        continue;
      }
      if (minWeightDVertex == null) {
        minWeightDVertex = d;
      } else if (d.getMinWeight() < minWeightDVertex.getMinWeight()) {
        minWeightDVertex = d;
      }
    }
    if (minWeightDVertex == null) {
      return null;
    }
    return minWeightDVertex.getVertex();
  }
}
