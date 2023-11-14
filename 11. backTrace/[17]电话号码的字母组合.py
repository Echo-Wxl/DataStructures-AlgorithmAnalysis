# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
# 
#  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
# 
#  
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：digits = "23"
# 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
#  
# 
#  示例 2： 
# 
#  
# 输入：digits = ""
# 输出：[]
#  
# 
#  示例 3： 
# 
#  
# 输入：digits = "2"
# 输出：["a","b","c"]
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= digits.length <= 4 
#  digits[i] 是范围 ['2', '9'] 的一个数字。 
#  
# 
#  Related Topics 哈希表 字符串 回溯 👍 2681 👎 0

from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    ds = ["", "", "abc", "def", "ghi", "jkl", "mno",  "pqrs",  "tuv", "wxyz"]

    def backtrace(self, A, i, box, ans):
        N = 0 if A is None else len(A)

        if len(box) == N:
            ans.append(box)

        if i>=N:
            return

        stoneIndex = int(A[i])
        for char in self.ds[stoneIndex]:
            box = box+char
            self.backtrace(A, i+1, box, ans)
            box = box[:-1]

    def letterCombinations(self, digits: str) -> List[str]:
        if digits is None or len(digits) == 0:
            return []

        box = ""
        ans = []
        self.backtrace(digits, 0, box, ans)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
