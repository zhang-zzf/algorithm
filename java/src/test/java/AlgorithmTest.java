import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import base.Algorithm;
import graph.bfs.BreadthFirstSearchAlgorithm;
import graph.dfs.DepthFirstSearchAlgorithm;
import graph.dijkstra.feng.DijkstraAlgorithm;
import graph.dijkstra.feng.Graph;
import graph.dijkstra.feng.Vertex;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import select.sort.heap.IntArrayHeapSort;
import select.sort.heap.MaxHeapSortIntArray;
import select.sort.merge.MergeSort2;

public class AlgorithmTest {

    public static final int[] ARRAY_ORIGINAL = new int[]{1, 8, 3, 9, 1, -5, -100, -33};
    public static final int[] ARRAY_SORTED = new int[]{-100, -33, -5, 1, 1, 3, 8, 9};
    public static final int[] ARRAY_SORTED2 = new int[]{9, 8, 3, 1, 1, -5, -33, -100};

    public static List<int[]> rank;

    static {
        rank = Algorithm.rank(ARRAY_ORIGINAL);
    }

    @Before
    public void beforClass() {

    }

    @Test
    public void testRemoveZero() {
        assertEquals("1", BigDecimal.valueOf(1).toString());
        assertEquals("0", Algorithm.removeZeroForDecimal(BigDecimal.ZERO));
        assertEquals("0", Algorithm.removeZeroForDecimal(new BigDecimal(0.00)));
        assertEquals("1", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(1)));
        assertEquals("1", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(1.00)));
        assertEquals("10", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(10)));
        assertEquals("10", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(10.000)));
        assertEquals("10.1", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(10.100)));
        assertEquals("10.01", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(10.01)));
        assertEquals("10.01", Algorithm.removeZeroForDecimal(BigDecimal.valueOf(10.0100)));
    }

    @Test
    public void testDeleteDuplicateSortedArray() {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            array.add(i);
        }

        // build array sample
        List<List<Integer>> arrays = new ArrayList<>(10000);
        arrays.add(new ArrayList<>(array));
        Random random = new Random(5);
        for (int i = 0; i < 10000; i++) {
            List<Integer> arraySample = new ArrayList<>();
            for (int j = 0; j < 11; j++) {
                Integer tmp = array.get(j);
                arraySample.add(tmp);
                for (int m = 0; m < random.nextInt(5); m++) {
                    arraySample.add(tmp);
                }
            }
            arrays.add(arraySample);
        }

        for (List<Integer> arraySample : arrays) {
            assertTrue(Algorithm.arrayDeleteDuplicate(arraySample).equals(array));
        }

        assertTrue(
            Algorithm.arrayDeleteDuplicate(Collections.emptyList()).equals(Collections.EMPTY_LIST));

        array = Arrays.asList(1);
        List<Integer> arraySample = new ArrayList<>();
        arraySample.add(1);
        assertTrue(Algorithm.arrayDeleteDuplicate(arraySample).equals(array));

        arraySample.add(1);
        assertTrue(Algorithm.arrayDeleteDuplicate(arraySample).equals(array));

        arraySample.add(1);
        assertTrue(Algorithm.arrayDeleteDuplicate(arraySample).equals(array));

    }

    @Test
    public void testDeleteDuplicateSortedArray2() {
        List<Integer> integers = Algorithm.arrayDeleteDuplicate2(Arrays.asList(1, 1, 1, 2, 2, 3));
        assertEquals(5, integers.size());
        integers = Algorithm.arrayDeleteDuplicate2(Arrays.asList(0, 0, 1, 1, 1, 1, 2, 3, 3));
        assertEquals(7, integers.size());

    }

    @Test
    public void testFindArrayMaxSubArray() {
        assertEquals(1, Algorithm.findArrayMaxSubArray(new int[]{1}));
        assertEquals(3, Algorithm.findArrayMaxSubArray(new int[]{1, 2}));
        assertEquals(1, Algorithm.findArrayMaxSubArray(new int[]{-5, 1, -2}));
        assertEquals(11, Algorithm.findArrayMaxSubArray(new int[]{-5, 8, -2, 5}));
        assertEquals(14, Algorithm.findArrayMaxSubArray(new int[]{-5, 8, -2, -7, 2, 3, 5, -2, 6}));

    }

    @Test
    public void testMaxHeapSortIntArray() {
        for (int[] a : rank) {
            MaxHeapSortIntArray.sort(a);
            assertArrayEquals(ARRAY_SORTED, a);
        }
    }

    @Test
    public void testMaxSubArray() {
        for (int[] array : rank) {
            int max = MaxSubArray.max(array);
            MaxSubArray.MaxData maxData = MaxSubArray.findMaxO_nlgn(array);
            MaxSubArray.MaxData m2 = MaxSubArray.findMaxO_n(array);
            MaxSubArray.MaxData m3 = MaxSubArray.findMaxDataO_n(array);
            int max2 = MaxSubArray.maxByDivideAndConquer(array);
            assertEquals(max, max2);
            assertEquals(max, maxData.getMax());
            assertEquals(max, m3.getMax());
            assertEquals(maxData, m3);
            //assertEquals(max, m2.getMax());
        }
    }

    @Test
    public void testInsertSort3() {
        for (int[] array : rank) {
            InsertSort.sort3(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testInsertSortRecursive() {
        for (int[] array : rank) {
            InsertSort.recursiveInsert(array, array.length);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testInsertSortWithBinarySearch() {
        for (int[] array : rank) {
            InsertSort.insertSortWithBinarySearch(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testReversePair() {
        for (int[] array : rank) {
            int count = ReversePair.count(array);
            int count2 = ReversePair.countByMergeSort(array);
            assertEquals(count, count2);
        }
    }

    @Test
    public void testMergeSort33() {
        for (int[] array : rank) {
            MergeSort.inserSortThenMerge(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testMergeSort22() {
        for (int[] array : rank) {
            MergeSort.sort(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testInsertSort() {
        for (int[] array : rank) {
            InsertSort.sort(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testQuickSort() {
        for (int[] array : rank) {
            QuickSort.sort(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
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
            MergeSort2.mergeSort2(array);
            assertArrayEquals(ARRAY_SORTED, array);
        }
    }

    @Test
    public void testMergeSort() {
        for (int[] array : rank) {
            MergeSort2.mergeSort(array);
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