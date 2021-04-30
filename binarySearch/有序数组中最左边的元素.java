/*
【题目】给定一个有序数组，返回指定元素在数组的最左边的位置

输入：A = [1, 2, 2, 2, 2, 3, 3], target = 2

输出：1

解释：第一个出现的 2 位于下标 1，是从左往右看时，第一个出现 2 的位置。

 */

class solution {
    // 返回指定元素在数组最左边的位置
    public int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            System.out.println("l:"+l);
            System.out.println("r:"+r);
            final int mid = l+((r-l)>>1);
            if (arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    /**
     * 最后边的位置
     * @param arr
     * @param target
     * @return
     */
    public int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            System.out.println("l:"+l);
            System.out.println("r:"+r);
            final int mid = l+((r-l)>>1);
            if (arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int binarySearch0(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int l = lowerBound(arr, target);
        if (l == arr.length || arr[l]!=target) {
            return -1;
        }
        return l;
    }
}