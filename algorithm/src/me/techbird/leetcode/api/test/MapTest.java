package me.techbird.leetcode.api.test;

import me.techbird.leetcode.api.map.Map;
import me.techbird.leetcode.api.map.TreeMap;

public class MapTest {
    public static void main(String[] args) {
    test();
    }

    static void test() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        map.put("d", 1);
        map.put("e", 1);

        map.traversal(new Map.Visitor<String, Integer>() {
            @Override
            public boolean visit(String key, Integer value) {
                System.out.println(key + "_" + value);
                return false;
            }
        });

        System.out.println(map.get("a"));
        map.remove("a");
        map.traversal(new Map.Visitor<String, Integer>() {
            @Override
            public boolean visit(String key, Integer value) {
                System.out.println(key + "_" + value);
                return false;
            }
        });
    }
}
