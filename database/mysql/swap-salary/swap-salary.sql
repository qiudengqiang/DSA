/*
https://leetcode-cn.com/problems/swap-salary/

给定一个 salary 表，如下所示，有 m=男性 和 f=女性 的值 。
交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求使用一个更新（Update）语句，
并且没有中间临时表。

请注意，你必须编写一个Update 语句，不要编写任何Select 语句。

例如:

| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |

运行你所编写的更新语句之后，将会得到以下表:

| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |

*/

--我的解法：使用IF（）语句
UPDATE salary
SET sex = IF(sex = 'm','f','m')

--官方解法：使用CASE...WHEN流程控制语句
--要想动态地将值设置成列，我们可以在使用 CASE...WHEN... 流程控制语句的同时使用UPDATE 语句。
UPDATE salary
SET
    sex = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END;