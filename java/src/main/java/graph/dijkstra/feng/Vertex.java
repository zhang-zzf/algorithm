package graph.dijkstra.feng;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Vertex {

  private String name;

  public Vertex(String name) {
    this.name = name;
  }
}
