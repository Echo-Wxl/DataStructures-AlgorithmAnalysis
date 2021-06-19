class solution {
    public void radixSort0(int[] arr) {
        int maxDigit = getMaxDigit(arr);
        int mod=10, dev=1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，[0-9]对应负数，[10-19]对应正数
            int[][] buckets = new int[mod*2][0];
            for (int j = 0; j < arr.length; j++) {
                int index = ((arr[j] % mod) / dev) + mod;
                buckets[index] = arrAppend(buckets[index], arr[j]);
            }

            int arrIndex = 0;
            for (int[] bucket : buckets) {
                for (int value : bucket) {
                    arr[arrIndex++] = value;
                }
            }
        }
    }

    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length-1] = value;
        return arr;
    }

    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }
    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
    private int getNumLength(int num) {
        if (num == 0) {
            return 1;
        }

        int length = 0;
        for (int temp = num; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }
}