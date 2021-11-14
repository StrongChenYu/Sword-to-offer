package structure.unionfind;

public class QuickFind implements UnionFind {

    private int[] id;
    private int count;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        id[pId] = qId;
        count--;
    }

    // 找到节点的根节点
    @Override
    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
