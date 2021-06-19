/*
【题目】江湖上有 N 个人，编号从 [1 ~ N]，现在只能告诉你，其中两人是一个帮派的，请你输出帮派的数目。

输入：N = 4, [[1, 2], [2,3]]

输出：2

解释：一共有 4 个人，[1,2, 3] 成为一个帮派，[4] 独自成为一个帮派，那么一共有 2 个帮派。
 */
class Solution{
    private int[] F = null;
    private int count = 0;

    private void Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
        }
        count = n;
    }

    private int Find(int x) {
        if (x == F(x)) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    private void Union(int x, int y) {
        int xpar = Find(x);
        int ypar = FInd(y);

        if (xpar != ypar) {
            F[xpar] = ypar;
            count--;
        }
    }

    public int findGangNumber(int n, int[][] conn) {
        Init(n);
        int m = conn.length;
        for (int i = 0; i < m; i++) {
            Union(conn[i][0], conn[i][1]);
        }
        return count;
    }
}