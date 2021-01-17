package me.techbird.api.test;

import me.techbird.api.set.Set;
import me.techbird.api.set.ListSet;

public class SetTest {
    public static void main(String[] args) {
        test();
    }

    static void test(){
        Set<String> set = new ListSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.traversal(new Set.Visitor<String>() {
            @Override
            public boolean visit(String element) {
                System.out.println(element);
                return false;
            }
        });
        set.remove("b");
        set.traversal(new Set.Visitor<String>() {
            @Override
            public boolean visit(String element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
