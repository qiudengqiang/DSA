package com.alphabethub.api.test;

import com.alphabethub.api.union.GenericUnionFind;
import com.alphabethub.api.union.UnionFind;
import com.alphabethub.api.union.UnionFind_QU_R_PH;
import com.alphabethub.tool.Asserts;
import com.alphabethub.tool.Times;
import me.techbird.api.union.*;

public class UnionFindTest {
    private static int count = 5000000;
    public static void main(String[] args) {
//        testTime(new UnionFind_QU_R(count));
//        testTime(new UnionFind_QU_R_PC(count));
//        testTime(new UnionFind_QU_R_PS(count));
        testTime(new UnionFind_QU_R_PH(count));
//        testTime(new UnionFind_QU_S(count));
        testTime(new GenericUnionFind<Integer>());

//        testTime(new UnionFind_QU(count));
//        testTime(new UnionFind_QF(count));
    }


    static void testTime(GenericUnionFind<Integer> uf) {
        for (int i = 0; i < count; i++) {
            uf.makeSet(i);
        }

        uf.makeSet(1);
        uf.makeSet(2);

        uf.makeSet(3);
        uf.makeSet(4);


        uf.union(1, 2);
        uf.union(3, 4);

        Asserts.test(uf.isSame(1, 2));

        Asserts.test(!uf.isSame(1, 4));

        Asserts.test(uf.isSame(3, 4));

        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }
        });
    }

    static void testTime(UnionFind uf) {
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(!uf.isSame(2, 7));

        uf.union(4, 6);

        Asserts.test(uf.isSame(2, 7));

        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }
        });
    }
}
