package com.alphabethub.string;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class _151_ReverseWords {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 思路：清除空格+3次翻转（大，小，最后）
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();

        //1.处理空格
        int cur = 0;//当前用来存放字符的位置
        int len = 0;//字符串最终的有效长度
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {//chars[i]是非空格字符
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {//chars[i]是空格字符，chars[i-1]是非空格字符
                chars[cur++] = ' ';
                space = true;
            }
        }

        //通过判断space可以知道i最后扫描的是不是空格字符
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";

        //2.翻转大字符串
        reverse(chars, 0, len);

        //3.翻转小字符串（每个单词）
        int prevSpaceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            reverse(chars, prevSpaceIdx + 1, i);
            prevSpaceIdx = i;
        }

        //4.翻转最后一个单词
        reverse(chars, prevSpaceIdx + 1, len);
        return new String(chars, 0, len);
    }

    /**
     * 将[li,ri)范围内的字符串进行逆序
     * @param chars
     * @param li
     * @param ri
     */
    private void reverse(char[] chars, int li, int ri) {
        //因为是左闭右开
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }
}
