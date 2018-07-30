package graph.dijkstra.feng;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Edge {
    private int weight;
    private Vertex next;
}
