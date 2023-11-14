from typing import List


def merge_sort(arr: List):
    if arr is None or len(arr) == 0:
        return
    temp = [0] * len(arr)
    merge_array(arr, 0, len(arr), temp)


def merge_array(arr: List, start: int, end: int, temp: List):
    if start >= end or start + 1 == end:
        return

    mid = start + ((end - start) >> 1)
    merge_array(arr, start, mid, temp)
    merge_array(arr, mid, end, temp)

    i = start
    j = mid
    k = start

    while i < mid or j < end:
        if j >= end or (i < mid and arr[i] < arr[j]):
            temp[k] = arr[i]
            k += 1
            i += 1
        else:
            temp[k] = arr[j]
            k += 1
            j += 1

    for l in range(start, end):
        arr[l] = temp[l]


if __name__ == '__main__':
    arr_list = [5, 9, -1, 0, 65, -93, 34]
    print(arr_list)
    merge_sort(arr_list)
    print(arr_list)
