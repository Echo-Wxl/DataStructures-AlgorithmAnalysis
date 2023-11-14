# 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
# 
#  你可以按 任何顺序 返回答案。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：n = 4, k = 2
# 输出：
# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ] 
# 
#  示例 2： 
# 
#  
# 输入：n = 1, k = 1
# 输出：[[1]] 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 20 
#  1 <= k <= n 
#  
# 
#  Related Topics 回溯 👍 1535 👎 0

from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def backtrace(self, end, k, i, box, ans):
        if len(box)==k:
            temp = []
            for x in box:
                temp.append(x)
            ans.append(temp)

        if len(box)>=k or i>=end:
            return

        for j in range(i, end):
            box.append(j)
            self.backtrace(end, k, j+1, box, ans)
            box.pop()

    def combine(self, n: int, k: int) -> List[List[int]]:
        box = []
        ans = []
        self.backtrace(n+1, k, 1, box, ans)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
