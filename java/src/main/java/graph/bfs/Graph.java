package graph.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<String, String[]> graph = new HashMap<>();

    public String[] getRelatedVertex(String vertex) {
        return graph.get(vertex);
    }

    public void addVertexs(String vertex, String[] relatedVertex) {
        graph.put(vertex, relatedVertex);
    }

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
}
