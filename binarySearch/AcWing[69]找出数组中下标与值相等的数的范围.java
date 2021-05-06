class Solution {
    private int getC(int[] arr, int i) {
        final int v = arr[i];
        if (v < i) {
            return -1;
        } else if (v == i) {
            return 0;
        }
        return 1;
    }

    private int getLeftSide(int[] arr) {
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
        return l;
    }

    private int getRightSide(int[] arr, int start) {
        int l = start, r = arr.length;
        while (l < r) {
            final int mid = l+((r-l)>>1);
            int mov = getC(arr, mid);
            if (mov <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int getNumberSameAsIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        final int l = getLeftSide(arr);
        final int r = getRightSide(arr, l);

        return l == r ? -1 : arr[l];
    }
}