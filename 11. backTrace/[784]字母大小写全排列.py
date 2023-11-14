# 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
# 
#  返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：s = "a1b2"
# 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
#  
# 
#  示例 2: 
# 
#  
# 输入: s = "3z4"
# 输出: ["3z4","3Z4"]
#  
# 
#  
# 
#  提示: 
# 
#  
#  1 <= s.length <= 12 
#  s 由小写英文字母、大写英文字母和数字组成 
#  
# 
#  Related Topics 位运算 字符串 回溯 👍 561 👎 0
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        if s is None or len(s) ==0:
            return []

        box = ""
        ans = []
        self.backtrace(s, 0, box, ans)
        return ans

    def backtrace(self, str, i, box, ans):
        N = 0 if str is None else len(str)

        if len(box)== N:
            ans.append(box)

        if i>=N:
            return

        char = str[i]
        if char.isdigit():
            box = box+char
            self.backtrace(str, i+1, box, ans)
            box = box[:-1]
        else:
            for ch in [char.lower(), char.upper()]:
                box = box + ch
                self.backtrace(str, i+1, box, ans)
                box = box[:-1]

# leetcode submit region end(Prohibit modification and deletion)
