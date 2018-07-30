package graph.bfs;

import java.util.*;

public class BreadthFirstSearchAlgorithm {

    public static String[] bfs(Graph graph, String start, String end) {
        if (end.equals(start)) {
            return new String[]{start};
        }

        Map<String, String> parentVertex = new HashMap<>();
        Deque<String> queue = new LinkedList<>();
        Set<String> searchedVertex = new HashSet<>();

        // init
        String curVertex = start;
        List<String> list = Arrays.asList(graph.getRelatedVertex(curVertex));
        for (String v : list) {
            parentVertex.put(v, curVertex);
        }
        queue.addAll(list);

        for (; queue.size() > 0; ) {
            curVertex = queue.pop();
            if (searchedVertex.contains(curVertex)) {
                continue;
            }

            if (end.equals(curVertex)) {
                break;
            } else {
                list = Arrays.asList(graph.getRelatedVertex(curVertex));
                for (String vertex : list) {
                    parentVertex.putIfAbsent(vertex, curVertex);
                }
                queue.addAll(list);
            }

            searchedVertex.add(curVertex);

        }

        if (curVertex.equals(end)) {
            // 找到
            return getPath(parentVertex, curVertex);
        } else {
            return new String[]{};
        }
    }

    private static String[] getPath(Map<String, String> parentVertex, String curVertex) {
        Deque<String> ret = new LinkedList<>();
        while (curVertex != null) {
            ret.addFirst(curVertex);
            curVertex = parentVertex.get(curVertex);
        }
        return ret.toArray(new String[]{});
    }
}
