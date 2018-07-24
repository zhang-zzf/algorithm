
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
    

