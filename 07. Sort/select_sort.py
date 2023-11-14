from typing import List


def select_sort(arr: List):
    length = len(arr)
    for i in range(length-1):
        min_index = i
        for j in range(i+1, length):
            if arr[min_index] > arr[j]:
                min_index = j

        if min_index != i:
            arr[min_index], arr[i] = arr[i], arr[min_index]


if __name__ == '__main__':
    arr_list = [5, 9, -1, 0, 65, -93, 34]
    print(arr_list)
    select_sort(arr_list)
    print(arr_list)
