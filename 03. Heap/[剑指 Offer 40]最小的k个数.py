# 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
# 
#  
# 
#  示例 1： 
# 
#  输入：arr = [3,2,1], k = 2
# 输出：[1,2] 或者 [2,1]
#  
# 
#  示例 2： 
# 
#  输入：arr = [0,1,2,1], k = 1
# 输出：[0] 
# 
#  
# 
#  限制： 
# 
#  
#  0 <= k <= arr.length <= 10000 
#  0 <= arr[i] <= 10000 
#  
# 
#  Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 515 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    a = []
    n = 0

    def _sink(self, i):
        t = self.a[i]
        while i + i + 1 < self.n:
            j = i + i + 1
            if j < self.n - 1 and self.a[j] < self.a[j+1]:
                j += 1
            if self.a[j] > t:
                self.a[i] = self.a[j]
                i = j
            else:
                break
        self.a[i] = t

    def _swim(self, i):
        t = self.a[i]
        while i > 0:
            par = (i-1) / 2
            if self.a[par] < t:
                self.a[i] = self.a[par]
                i = par
            else:
                break
        self.a[i] = t

    def push(self, x):
        self.a.append(x)
        self._swim(self.n)
        self.n += 1

    def pop(self):
        ret = self.a[0]
        self.a[0] = self.a[self.n-1]
        self.a.pop()
        self.n -= 1
        self._sink(0)
        return ret

    def size(self):
        return self.n

    def getLeastNumbers(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: List[int]
        """

        if k <= 0 or (not arr) or len(arr) == 0:
            return []

        self.a = []
        self.n = 0

        for x in arr:
            self.push(x)
            while self.size() > k:
                self.pop()

        return self.a


# leetcode submit region end(Prohibit modification and deletion)
