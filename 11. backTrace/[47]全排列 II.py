# 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,1,2]
# 输出：
# [[1,1,2],
#  [1,2,1],
#  [2,1,1]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 8 
#  -10 <= nums[i] <= 10 
#  
# 
#  Related Topics 数组 回溯 👍 1494 👎 0
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def backtrace(self, nums, i, ans):
        N = 0 if not nums else len(nums)

        if i>=N:
            ans.append([])
            for x in nums:
                ans[-1].append(x)
            return

        s = set()
        for j in range(i, N):
            if nums[j] not in s:
                s.add(nums[j])
                nums[j], nums[i] = nums[i], nums[j]
                self.backtrace(nums, j+1, ans)
                nums[i], nums[j] = nums[j], nums[i]


    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        self.backtrace(nums, 0, ans)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
