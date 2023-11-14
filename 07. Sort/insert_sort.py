from typing import List


def insert_sort(arr: List):
    length = len(arr)
    for i in range(length - 1):
        for j in range(i + 1, 0, -1):
            if arr[j] < arr[j - 1]:
                arr[j], arr[j - 1] = arr[j - 1], arr[j]

            else:
                break


if __name__ == '__main__':
    arr_list = [5, 9, -1, 0, 65, -93, 34]
    print(arr_list)
    insert_sort(arr_list)
    print(arr_list)
