class solution {
    private int getC(int[] arr, int i) {
        final int x = arr[i];
        if (x < i) {
            return -1;
        } else if (x == i) {
            return 0;
        }
        return 1;
    }

    public int getNumberSameAsIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length;
        while (l < r) {
            final int mid = l + ((r - l) >> 1);
            int mov = getC(arr, mid);
            if (mov < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l < arr.length && arr[l] == l) {
            return 1;
        }
        return -1;
    }
}