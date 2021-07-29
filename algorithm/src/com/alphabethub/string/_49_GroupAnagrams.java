package com.alphabethub.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
 * 题意解释：把是异位词的单词分为一组，最后返回多个组。
 * 思路：利用hashmap中映射，字符排序之后作为映射的键保证键的唯一性。
 */
public class _49_GroupAnagrams {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return map.values().stream().collect(Collectors.toList());
    }

}
