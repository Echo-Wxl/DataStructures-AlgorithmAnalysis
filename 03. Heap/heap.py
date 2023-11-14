class Heap:
    def __init__(self):
        self.arr = list()
        self.n = 0

    def _sink(self, i):
        j = 2 * i + 1
        t = self.arr[i]

        while j < self.n:
            if j + 1 < self.n and self.arr[j] < self.arr[j + 1]:
                j += 1

            if self.arr[j] > t:
                self.arr[i] = self.arr[j]
                i = j
                j = 2 * i + 1
            else:
                break

        self.arr[i] = t

    def _swim(self, i):
        t = self.arr[i]
        par = int((i-1)/2)

        while 0 < i != par:

            if self.arr[par] < t:
                self.arr[i] = self.arr[par]
                i = par
                par = int((i - 1) / 1)
            else:
                break
        self.arr[i] = t

    def push(self, val):
        """
        入堆：
        1. 先把元素加在最后
        2. 进行上浮操作
        :param val:
        :return:
        """
        self.arr[self.n] = val
        self.n += 1
        self._swim(self.n-1)

    def pop(self):
        """
        出堆：
        1. 去除heap[0]的值作为返回值
        2. 将heap[n-1]的存放在heap[0]
        3. 将heap[0]进行下沉操作
        :return:
        """
        res = self.arr[0]
        self.n -= 1
        self.arr[0] = self.arr[self.n]
        self._sink(0)
        return res

    def size(self):
        return self.n
