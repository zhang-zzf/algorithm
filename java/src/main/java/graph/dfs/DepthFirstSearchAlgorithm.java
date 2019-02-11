package graph.dfs;

import graph.bfs.Graph;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhanfeng.zhang
 * @email zhanfeng.zhang@xqchuxing.com
 * @date 2018-10-23 20:37
 * @description TODO
 **/
public class DepthFirstSearchAlgorithm {


  public static boolean search(Graph g, String start, String end) {
    Set<String> searched = new HashSet<>();
    Deque<String> stack = new LinkedList();

    stack.push(start);
    while (!stack.isEmpty()) {
      String pop = stack.pop();
      if (end.equals(pop)) {
        return true;
      } else {
        searched.add(pop);
        Arrays.stream(g.getRelatedVertex(pop))
            .filter(v -> !pop.equals(v) && !searched.contains(v))
            .forEach(v -> stack.push(v));
      }
    }
    return false;
  }

}
