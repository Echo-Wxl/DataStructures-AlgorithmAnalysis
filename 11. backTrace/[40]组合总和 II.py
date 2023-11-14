# 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
# 
#  candidates 中的每个数字在每个组合中只能使用 一次 。 
# 
#  注意：解集不能包含重复的组合。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: candidates = [10,1,2,7,6,1,5], target = 8,
# 输出:
# [
# [1,1,6],
# [1,2,5],
# [1,7],
# [2,6]
# ] 
# 
#  示例 2: 
# 
#  
# 输入: candidates = [2,5,2,1,2], target = 5,
# 输出:
# [
# [1,2,2],
# [5]
# ] 
# 
#  
# 
#  提示: 
# 
#  
#  1 <= candidates.length <= 100 
#  1 <= candidates[i] <= 50 
#  1 <= target <= 30 
#  
# 
#  Related Topics 数组 回溯 👍 1476 👎 0
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def backtrace(self, nums, i, target, box, ans):
        N = 0 if not nums else len(nums)

        if sum(box)==target:
            ans.append([])
            for x in box:
                ans[-1].append(x)

        if sum(box) >= target or i>=N:
            return

        for j in range(i, N):
            if j>i and nums[j]==nums[j-1]:
                continue
            box.append(nums[j])
            self.backtrace(nums, j+1, target, box, ans)
            box.pop()

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        box = []
        ans = []
        candidates.sort()
        self.backtrace(candidates, 0, target, box, ans)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
