package algorithms;

class BinarySearch {

    // Initial call can be binarySearch(arr, 0, arr.length, key)
    public static int binarySearch(int[] arr, int l, int r, int key){
        int index = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(l == r || arr[mid] == key){
                index = mid;
                break;
            } else if(arr[mid] < key)
                l = mid + 1;
            else
                r = mid;
        }
        return index;
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