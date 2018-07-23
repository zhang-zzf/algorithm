
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
