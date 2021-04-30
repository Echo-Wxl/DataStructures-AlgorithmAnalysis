class solution {
    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            final int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) {
                l = mid+1;
            } else if (arr[mid] > target) {
                r = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}