from typing import List


def swap(arr: List, i: int, j: int):
    arr[i], arr[j] = arr[j], arr[i]


def quick_sort(arr: List, start: int, end: int):
    if start >= end or start + 1 == end:
        return

    mid = start + ((end - start) >> 1)
    pivot = arr[mid]

    left = i = start
    right = end - 1

    while i <= right:
        if arr[i] < pivot:
            swap(arr, i, left)
            left += 1
            i += 1
        elif arr[i] == pivot:
            i += 1
        else:
            swap(arr, i, right)
            right -= 1

    quick_sort(arr, start, mid)
    quick_sort(arr, mid, end)


if __name__ == '__main__':
    arr_list = [5, 9, -1, 0, 65, -93, 34]
    print(arr_list)
    quick_sort(arr_list, 0, len(arr_list))
    print(arr_list)
