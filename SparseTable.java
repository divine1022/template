class SparseTable {
    int n;
    int[][] f;
    int[] log2;

    private int fun(int x, int y) {
        // TODO
        return ;
    }

    public SparseTable(int[] a) {
        n = a.length;
        log2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }
        f = new int[n][log2[n] + 1];
        // set f
        for (int j = 0; j <= log2[n]; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                if (j == 0) {
                    f[i][j] = a[i];
                } else {
                    f[i][j] = fun(f[i][j - 1], f[i + (1 << j - 1)][j - 1]);
                }
            }
        }
    }

    public int query(int l, int r) {
        int k = log2[r - l + 1];
        return fun(f[l][k], f[r - (1 << k) + 1][k]);
    }
}