import graph.bfs.BreadthFirstSearchAlgorithm;
import graph.dijkstra.feng.DijkstraAlgorithm;
import graph.dijkstra.feng.Graph;
import graph.dijkstra.feng.Vertex;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AlgorithmTest {

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
    public void selectionSort() {
        int[] list = {1, 8, 3, 9, 11};
        Algorithm.selectionSort(list);
        assertArrayEquals(new int[]{11, 9, 8, 3, 1}, list);
    }

    @Test
    public void recursionQuickSort() {
        int[] list = {1, 8, 3, 9, 1, 100, 88, -50, -100};
        Algorithm.recursionQuickSort(list, 0, list.length);
        assertArrayEquals(new int[]{ -100, -50, 1, 1, 3, 8, 9, 88, 100}, list);
    }

    @Test
    public void quickSort() {
        int[] list = {1, 8, 3, 9, 1, 100, 88, -50, -100};
        Algorithm.quickSort(list, 0, list.length);
        assertArrayEquals(new int[]{ -100, -50, 1, 1, 3, 8, 9, 88, 100}, list);
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
        List<Vertex> vertices = DijkstraAlgorithm.dijkstraGraph(g, new Vertex("start"), new Vertex("stop"));
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
}