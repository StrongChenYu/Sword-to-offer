package structure.unionfind;

/**
 * @Author Chen Yu
 * @Date 2021/8/16 20:58
 */
public class UF_QuickWeightUnion {
    private int[] id;
    private int[] sz;
    private int count;

    public UF_QuickWeightUnion(int N, boolean b) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; b; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (sz[pRoot] > sz[qRoot]) {
            //p根的节点数多
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            //p根的节点数少
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
    }
}
