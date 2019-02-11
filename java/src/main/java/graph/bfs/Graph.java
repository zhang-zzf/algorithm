package graph.bfs;

import java.util.HashMap;
import java.util.Map;

public class Graph {

  private Map<String, String[]> graph = new HashMap<>();

  public static Graph generate() {
    Graph ret = new Graph();
    ret.addVertexs("me", new String[]{"alice", "bob", "claire"});
    ret.addVertexs("bob", new String[]{"anuj", "peggy"});
    ret.addVertexs("alice", new String[]{"peggy"});
    ret.addVertexs("claire", new String[]{"thom", "jonny"});
    ret.addVertexs("anuj", new String[]{});
    ret.addVertexs("peggy", new String[]{});
    ret.addVertexs("thom", new String[]{});
    ret.addVertexs("jonny", new String[]{});
    return ret;
  }

  public static Graph generate2() {
    Graph g = new Graph();
    g.addVertexs("A", "B", "C");
    g.addVertexs("B", "A", "D", "E", "F");
    g.addVertexs("C", "A", "G", "H");
    g.addVertexs("D", "B", "I");
    g.addVertexs("E", "B");
    g.addVertexs("F", "B", "J");
    g.addVertexs("G", "C");
    g.addVertexs("H", "C");
    g.addVertexs("I", "D");
    g.addVertexs("J", "F");
    return g;
  }

  public String[] getRelatedVertex(String vertex) {
    return graph.get(vertex);
  }

  public void addVertexs(String vertex, String... relatedVertex) {
    graph.put(vertex, relatedVertex);
  }
}
