# 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [0,1]
# 输出：[[0,1],[1,0]]
#  
# 
#  示例 3： 
# 
#  
# 输入：nums = [1]
# 输出：[[1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 6 
#  -10 <= nums[i] <= 10 
#  nums 中的所有整数 互不相同 
#  
# 
#  Related Topics 数组 回溯 👍 2743 👎 0

from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def backtrace(self, nums, i,used,  box, ans):
        N = 0 if not nums else len(nums)
        if len(box)==N:
            ans.append([])
            for x in box:
                ans[-1].append(x)

        if i>=N:
            return

        for j in range(N):
            if not used[j]:
                used[j] = True
                box.append(nums[j])
                self.backtrace(nums, j, used, box, ans)
                box.pop()
                used[j] =False

    def permute(self, nums: List[int]) -> List[List[int]]:
        box = []
        ans = []
        used = [False]*len(nums)
        self.backtrace(nums, 0,used, box, ans)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
