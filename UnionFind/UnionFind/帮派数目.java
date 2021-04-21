public class BangPai {
    public static void main(String[] args) {
        int N = 4;
        int[][] conn = {{1, 2}, {2, 3}};
        int number = findBnagPaiNumber(4, conn);
        System.out.println(number);
    }

    /**
     * 找到帮派的数量
     * @param n
     * @param conn
     * @return
     */
    public static int findBnagPaiNumber(int n, int[][] conn) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < conn.length; i++) {
            uf.Union(conn[i][0], conn[i][1]);
        }
        return uf.count;
    }
}
