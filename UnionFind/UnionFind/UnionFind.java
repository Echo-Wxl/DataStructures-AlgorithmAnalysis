public class UnionFind {
    // 并查集数组
    private int[] UF = null;
    // count记录并查集中集合的个数
    public int count = 0;
    // 记录集合中点的个数，比如要知道i所在集合的点有多少个
    private int[] Cnt = null;

    public UnionFind(){}
    // 初始化并查集
    public UnionFind(int n) {
        UF = new int[n];
        Cnt = new int[n];
        for (int i = 0; i < n; i++) {
            UF[i] = i;
            Cnt[i] = 1;
        }
        count = n;
    }

    public int Find(int x) {
        if (x == UF[x]) {
            return x;
        }
        UF[x] = Find(UF[x]);
        return UF[x];
    }

    public boolean connection(int x, int y) {
        return Find(x) == Find(y);
    }

    public void Union(int x, int y) {
        int xPar = Find(x);
        int yPar = Find(y);

        if (xPar == yPar) {
            return;
        }

        // 判断xPar和yPar所对应树的大小，把小树合并到大树中
        if (Cnt[xPar] < Cnt[yPar]) {
            UF[xPar] = yPar;
            Cnt[yPar] += Cnt[xPar];
        } else{
            UF[yPar] = xPar;
            // 更新Cnt和count
            Cnt[xPar] += Cnt[yPar];
        }
        count--;
    }

    // 查询i所在集合的点有多少个
    public int size(int i) {
        return Cnt[Find(i)];
    }

}
