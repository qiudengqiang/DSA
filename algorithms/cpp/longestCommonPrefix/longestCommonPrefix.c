//
//  LongestCommonPrefix.c
//  Exam
//
//  Created by techbird on 2019/1/22.
//  Copyright © 2019 apple. All rights reserved.
//

#include <stdio.h>
#include <string.h>
/**
 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。
 
 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"
 
 示例 2:
 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 */

char* longestCommonPrefix(char** strs, int strsSize) {
    //要明白是比较数组中所有字符的公共最大前缀
    //思路:把数组看做一个二维数组，逐个字符进行比较
    char* str = strs[0];
    int i,j;
    
    if(strsSize == 0) return "";
    
    for(i=1;i<strsSize;i++){
        j=0;
        while(str[j] && strs[i][j] && str[j]==strs[i][j]){
            j++;
        }
        str[j]='\0';
    }
    return str;
}

