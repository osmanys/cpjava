package algorithms;

class BinarySearch {

    public static int binarySearch(int search, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (search < array[middle])
                end = middle - 1;
            else if (search > array[middle])
                start = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    public static int binarySearchRecursive(int search, int[] array, int start, int end) {
        int middle = (start + end) / 2;
        if (end < start)
            return -1;

        if (search < array[middle])
            return binarySearchRecursive(search, array, start, middle - 1);
        else if (search > array[middle])
            return binarySearchRecursive(search, array, middle + 1, end);
        else
            return middle;

        return -1;
    }
}