class UF{
    int[] F = null;

    int count = 0;

    int[] Cnt = null;

    public void Init(int n) {
        F = new int[n];
        Cnt = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
            Cnt[i]=1;
        }
        count = n;
    }

    public int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    public void Union(int x, int y) {
        int xpar = Find(x);
        int ypar = Find(y);
        // 将集合x合并到集合y中
        if (xpar != ypar) {
            F[xpar] = ypar;
            Cnt[ypar] += Cnt[xpar];
            count--;
        }
    }

    public int size(int i) {
        return Cnt[Find(i)];
    }
}