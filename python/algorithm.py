from stack import Stack
from collections import deque


def dijkstra_search(graph, start, end):
    """
    狄克斯特拉（带权最小路径）算法
    适用范围：带权（无负权制）无环 有向 图
    """
    parent_vertex = {}

    # init weight
    vertex_weight = {}
    for vertex in graph.keys():
        weight = float("inf")
        if (vertex == start):
            weight = 0
        vertex_weight[vertex] = {"w": weight, "searched": False}

    min_weight_vertex = _dijkstra_get_min_weight_vertex(vertex_weight)
    while min_weight_vertex is not None:
        vertex_weight[min_weight_vertex]["searched"] = True
        weight =  vertex_weight[min_weight_vertex]["w"]

        edges = graph[min_weight_vertex]
        for vertex in edges.keys():
            weight_tmp = weight + edges[vertex]
            if weight_tmp < vertex_weight[vertex]["w"]:
                vertex_weight[vertex]["w"] = weight_tmp
                parent_vertex[vertex] = min_weight_vertex
        min_weight_vertex = _dijkstra_get_min_weight_vertex(vertex_weight)

    path = _dijkstra_extractPath(parent_vertex, start, end)
    return {"min_weight": vertex_weight[end]["w"] ,"path": list(path)}

def _dijkstra_extractPath(parent_vertex, start, end):
    ret = deque()
    vertex = end
    while vertex != start:
        ret.appendleft(vertex)
        vertex = parent_vertex[vertex]
    ret.appendleft(start)
    return ret

def _dijkstra_get_min_weight_vertex(vertex_weight):
    min_weight = float("inf")
    min_weight_vertex = None
    for vertex in vertex_weight.keys():
        weight_node = vertex_weight[vertex]
        if (not weight_node["searched"]) and (weight_node["w"] < min_weight):
            min_weight = weight_node["w"]
            min_weight_vertex = vertex
    return min_weight_vertex


def breadth_first_search(graph, start, end):
    """
    广度优先搜索算法
    """
    searched_set = set()
    search_list = deque()
    search_list.extend(graph[start])
    while (search_list):
        person = search_list.popleft()
        if (person in searched_set):
            continue
        if (person == end):
            return True
        else:
            search_list.extend(graph[person])
        searched_set.add(person)
    return False


def breadth_first_search_with_path(graph, start, end):
    """
    广度优先搜索算法,返回路径
    """

    parent_vertex = {}
    searched_set = set()
    search_list = deque()

    # init
    curVertex = start
    vertexs = graph[curVertex]
    for vertex in vertexs:
        parent_vertex[vertex] = curVertex
    search_list.extend(vertexs)

    while (search_list):
        curVertex = search_list.popleft()
        if (curVertex in searched_set):
            continue
        if (curVertex == end):
            break
        else:
            vertexs = graph[curVertex]
            for vertex in vertexs:
                if (not (vertex in parent_vertex)):
                    parent_vertex[vertex] = curVertex
            search_list.extend(vertexs)
        searched_set.add(curVertex)
    if (curVertex == end):
        return _bfs_path(parent_vertex, start, curVertex)
    else:
        return []


def _bfs_path(parent_vertex, start, curVertex):
    ret = deque()
    while (curVertex in parent_vertex):
        ret.appendleft(curVertex)
        curVertex = parent_vertex[curVertex]
    ret.appendleft(start)
    return ret


def binary_search(sorted_list, value):
    """
        二分查找/折半查找
    """
    low = 0
    high = len(sorted_list) - 1
    while (low <= high):
        mid = int((low + high)/2)
        value_mid = sorted_list[mid]
        if (value_mid == value):
            return mid
        elif (value_mid < value):
            low = mid + 1
        else:
            high = mid - 1
    return None


def recursion_binary_search(sorted_list, value, start, end):
    if (len(sorted_list) == 0):
        return None
    if (start == end - 1):
        if (sorted_list[start] == value):
            return start
        else:
            return None
    elif (start > end - 1):
        return None

    mid_index = int((start + end - 1) / 2)
    mid_value = sorted_list[mid_index]
    if (mid_value == value):
        return mid_index
    elif (mid_value < value):
        return recursion_binary_search(sorted_list, value, mid_index + 1, end)
    else:
        return recursion_binary_search(sorted_list, value, start, mid_index)


def selection_sort(ordinary_list):
    """
        选择排序
    """

    lng = len(ordinary_list)
    for index in range(lng):
        max_index = index
        for search_index in range(index + 1, lng):
            if (ordinary_list[search_index] > ordinary_list[max_index]):
                max_index = search_index
        _swap(ordinary_list, index, max_index)


def _swap(list, index_1, index_2):
    """
    交换列表中的2个元素
    """
    if (index_1 == index_2):
        return None
    tmp = list[index_1]
    list[index_1] = list[index_2]
    list[index_2] = tmp


def factorial(n):
    if (n == 0 or n == 1):
        return 1
    return n * factorial(n-1)


def factorial2(n):
    ret = 1
    for i in range(1, n + 1):
        ret *= i
    return ret


def recursion_sum(lst=[]):
    """
    采用递归方法求和
    """
    lng = len(lst)
    if (lng == 0):
        return 0
    elif (lng == 1):
        return lst[0]
    return lst.pop() + recursion_sum(lst)


def recursion_sum2(lst=[], start=0, stop=0):
    """
    采用递归方法求和
    """
    if (len(lst) == 0):
        return 0
    lng = stop - start
    if (lng <= 0):
        return 0
    elif (lng == 1):
        return lst[start]
    return lst[start] + recursion_sum2(lst, start + 1, stop)


def recursion_max_value(lst=[], start=0, end=0):
    """
    递归算出列表中的最大值
    """
    if (len(lst) == 0):
        return None
    lng = end - start
    if (lng <= 0):
        return None
    if (lng == 1):
        return lst[start]

    guess = recursion_max_value(lst, start + 1, end)
    if (guess > lst[start]):
        return guess
    else:
        return lst[start]


def recursion_quick_sort(lst, start, end):
    """
    快速排序
    """
    low = start
    high = end - 1
    # 基线条件
    if (low >= high):
        return
    index = _partSort(lst, low, high)
    recursion_quick_sort(lst, start, index)
    recursion_quick_sort(lst, index + 1, end)


def quick_sort(lst, start, end):
    """
    快速排序
    """
    low = start
    high = end - 1
    if (low >= high):
        return None
    stack = Stack()
    stack.push(low)
    stack.push(high)

    while (stack.size() > 0):
        high = stack.poll()
        low = stack.poll()
        index = _partSort(lst, low, high)
        if (low < index - 1):
            stack.push(low)
            stack.push(index - 1)
        if (index + 1 < high):
            stack.push(index + 1)
            stack.push(high)


def _partSort(lst, left, right):
    """
    分区排序，快速排序的核心
    """
    pivot_index = right
    pivot = lst[pivot_index]
    while (left < right):
        while (left < right and lst[left] <= pivot):
            left += 1
        while (left < right and lst[right] >= pivot):
            right -= 1
        _swap(lst, left, right)
    _swap(lst, left, pivot_index)
    return left
