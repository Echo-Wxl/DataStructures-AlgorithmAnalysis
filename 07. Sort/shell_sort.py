from typing import List


def shell_sort(arr: List):
    length = len(arr)
    incre = length

    while True:
        incre = int(incre/2)
        for i in range(incre):
            for j in range(i+incre, length, incre):
                for k in range(j, i, -incre):
                    if arr[k] < arr[k-incre]:
                        arr[k], arr[k-incre] = arr[k-incre], arr[k]
                    else:
                        break

        if incre == 1:
            break


if __name__ == '__main__':
    arr_list = [5, 9, -1, 0, 65, -93, 34]
    print(arr_list)
    shell_sort(arr_list)
    print(arr_list)
