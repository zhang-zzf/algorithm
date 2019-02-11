package graph.dijkstra.better;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Edge {

  private int weight;
  private String tail;
}
