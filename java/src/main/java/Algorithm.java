public class Algorithm {

    /**
     * 二分查找/折半查找
     *
     * @param sortedList
     * @param value
     * @return index/-1
     */
    public static int binarySearch(int[] sortedList, int value) {
        int low = 0, high = sortedList.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = sortedList[mid];
            if (value == guess) {
                return mid;
            } else if (guess < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
