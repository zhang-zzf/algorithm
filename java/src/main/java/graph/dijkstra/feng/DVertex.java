package graph.dijkstra.feng;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DVertex {

  private boolean handled; //是否已处理
  private int minWeight;
  private Vertex vertex; // 当前节点
  private Vertex pre; // 上一个节点
}
