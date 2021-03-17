package me.techbird.api.union;

/**
 * Quick Find
 */
public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {//O(1)
        rangeCheck(v);
        return parents[v];
    }

    @Override
    public void union(int v1, int v2) {//O(n)
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }
}
