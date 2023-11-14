from typing import List


def bubble_sort(arr: List):
    length = len(arr)
    flag = False
    for i in range(length):
        if flag:
            break
        else:
            flag = True
            for j in range(length - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
                    flag = False


if __name__ == '__main__':
    arr_list = [5, 9, -1, 0, 65, -93, 34]
    print(arr_list)
    bubble_sort(arr_list)
    print(arr_list)
