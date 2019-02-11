import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import graph.bfs.BreadthFirstSearchAlgorithm;
import graph.dfs.DepthFirstSearchAlgorithm;
import graph.dijkstra.feng.DijkstraAlgorithm;
import graph.dijkstra.feng.Graph;
import graph.dijkstra.feng.Vertex;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import select.sort.heap.IntArrayHeapSort;
import select.sort.merge.MergeSort;

public class AlgorithmTest {

  private static final int[] ARRAY_ORIGINAL = new int[]{1, 8, 3, 9, 1, -5, -100, -33};
  private static final int[] ARRAY_SORTED = new int[]{-100, -33, -5, 1, 1, 3, 8, 9};
  private static final int[] ARRAY_SORTED2 = new int[]{9, 8, 3, 1, 1, -5, -33, -100};

  private static List<int[]> rank;

  @Before
  public void beforClass() {
    rank = Algorithm.rank(ARRAY_ORIGINAL);
  }

  @Test
  public void testHeapFindKMax() {
    for (int[] array : rank) {
      assertEquals(3, Algorithm.heapFindKMax(array, 3));
      assertEquals(1, Algorithm.heapFindKMax(array, 5));
    }
  }

  @Test
  public void testFindSecondMax() {
    for (int[] array : rank) {
      int secondMax = Algorithm.findSecondMaxWrong(array);
      assertEquals(8, secondMax);
    }
  }

  @Test
  public void testquickSortFindKMax() {
    for (int[] array : rank) {
      assertEquals(8, Algorithm.quickSortFindKMax(array, 2));
      assertEquals(3, Algorithm.quickSortFindKMax(array, 3));
      assertEquals(1, Algorithm.quickSortFindKMax(array, 4));
    }
  }

  @Test
  public void testMergeSort2() {
    for (int[] array : rank) {
      MergeSort.mergeSort2(array);
      assertArrayEquals(ARRAY_SORTED, array);
    }
  }

  @Test
  public void testMergeSort() {
    for (int[] array : rank) {
      MergeSort.mergeSort(array);
      assertArrayEquals(ARRAY_SORTED, array);
    }
  }

  @Test
  public void testHeapSort() {
    for (int[] array : rank) {
      IntArrayHeapSort.heapSort(array);
      assertArrayEquals(ARRAY_SORTED2, array);
    }
  }

  @Test
  public void depthFirstSearch() {
    graph.bfs.Graph g = graph.bfs.Graph.generate2();
    boolean result = DepthFirstSearchAlgorithm.search(g, "B", "H");
    assertTrue(result);
  }

  @Test
  public void binarySearch() {
    int[] sortedList = {1, 3, 5, 7, 9};
    int index = Algorithm.binarySearch(sortedList, 7);
    assertEquals(3, index);
    index = Algorithm.binarySearch(sortedList, 10);
    assertEquals(-1, index);

    index = Algorithm.binarySearch(sortedList, 3);
    assertEquals(1, index);
  }

  @Test
  public void binarySearchSmallestIndex() {
    int[] sortedList = {1, 3, 3, 3, 3, 5, 5, 7, 7, 7, 7, 8, 9,};
    int idx = Algorithm.binarySearchSmallestIndex(sortedList, 3);
    assertEquals(1, idx);
    idx = Algorithm.binarySearchSmallestIndex(sortedList, 7);
    assertEquals(7, idx);
    idx = Algorithm.binarySearchSmallestIndex(sortedList, 2);
    assertEquals(-1, idx);
    idx = Algorithm.binarySearchSmallestIndex(sortedList, 1000);
    assertEquals(-1, idx);

  }

  @Test
  public void selectionSort() {
    int[] list = {1, 8, 3, 9, 11};
    Algorithm.selectionSort(list);
    assertArrayEquals(new int[]{11, 9, 8, 3, 1}, list);
  }

  @Test
  public void recursionQuickSort() {
    int[] list = {1, 8, 3, 9, 1, 100, 88, -50, -100};
    Algorithm.recursionQuickSort(list, 0, list.length);
    assertArrayEquals(new int[]{-100, -50, 1, 1, 3, 8, 9, 88, 100}, list);
    for (int[] array : rank) {
      Algorithm.recursionQuickSort(array, 0, array.length);
      assertArrayEquals(ARRAY_SORTED, array);
    }
  }

  @Test
  public void quickSort() {
    int[] list = {1, 8, 3, 9, 1, 100, 88, -50, -100};
    Algorithm.quickSort(list, 0, list.length);
    assertArrayEquals(new int[]{-100, -50, 1, 1, 3, 8, 9, 88, 100}, list);
    for (int[] array : rank) {
      Algorithm.quickSort(array, 0, array.length);
      assertArrayEquals(ARRAY_SORTED, array);
    }
  }

  @Test
  public void gcd() {
    int gcd = Algorithm.recursionGcd(100, 8888);
    assertEquals(4, gcd);
    assertEquals(gcd, Algorithm.recursionGcd(8888, 100));
    assertEquals(gcd, Algorithm.gcd(100, 8888));
    assertEquals(gcd, Algorithm.gcd(8888, 100));
  }

  @Test
  public void dijkstraGraph() {
    Graph g = Graph.generateGraph();
    List<Vertex> minWeightVertexs = new LinkedList<>();
    minWeightVertexs.add(Vertex.builder().name("start").build());
    minWeightVertexs.add(Vertex.builder().name("B").build());
    minWeightVertexs.add(Vertex.builder().name("C").build());
    minWeightVertexs.add(Vertex.builder().name("stop").build());
    List<Vertex> vertices = DijkstraAlgorithm
        .dijkstraGraph(g, new Vertex("start"), new Vertex("stop"));
    assertArrayEquals(minWeightVertexs.toArray(), vertices.toArray());
  }


  @Test
  public void dijkstraGraph2() {
    graph.dijkstra.better.Graph g = graph.dijkstra.better.Graph.generateGraph();
    assertEquals(4, graph.dijkstra.better.DijkstraAlgorithm.dijkstra(g, "a", "e"));
    assertEquals(1, graph.dijkstra.better.DijkstraAlgorithm.dijkstra(g, "a", "b"));
    assertEquals(10, graph.dijkstra.better.DijkstraAlgorithm.dijkstra(g, "a", "c"));
    assertEquals(40, graph.dijkstra.better.DijkstraAlgorithm.dijkstra(g, "f", "d"));
    assertEquals(50, graph.dijkstra.better.DijkstraAlgorithm.dijkstra(g, "f", "e"));
  }

  @Test
  public void bfs() {
    String[] bfs = BreadthFirstSearchAlgorithm.bfs(graph.bfs.Graph.generate(), "me", "peggy");
    assertEquals(3, bfs.length);

    bfs = BreadthFirstSearchAlgorithm.bfs(graph.bfs.Graph.generate(), "me", "thom");
    assertEquals(3, bfs.length);

    bfs = BreadthFirstSearchAlgorithm.bfs(graph.bfs.Graph.generate(), "me", "dddd");
    assertEquals(0, bfs.length);
  }

  @Test
  public void dualPivotQuickSort() {
    int[] list = {1, 8, 3, 9, 1, 100, 88, -50, -100};
    Algorithm.dualPivotQuickSort(list);
    assertArrayEquals(new int[]{-100, -50, 1, 1, 3, 8, 9, 88, 100}, list);
    for (int[] array : rank) {
      Algorithm.quickSort(array, 0, array.length);
      assertArrayEquals(ARRAY_SORTED, array);
    }
  }

  @Test
  public void rank() {
    int[] list = {1, 2, 3, 4};
    List<int[]> rank = Algorithm.rank(list);
    for (int[] array : rank) {
      System.out.println(Arrays.toString(array));
    }
    assertEquals(24, rank.size());
  }

  @Test
  public void factorial() {
    assertEquals(1, Algorithm.factorial(0));
    assertEquals(1, Algorithm.factorial(1));
    assertEquals(6, Algorithm.factorial(3));
    assertEquals(40320, Algorithm.factorial(8));
  }
}