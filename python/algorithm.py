
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
