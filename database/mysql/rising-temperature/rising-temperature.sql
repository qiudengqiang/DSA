/*
https://leetcode-cn.com/problems/rising-temperature/
给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。

+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
例如，根据上述给定的 Weather 表格，返回如下Id:

+----+
| Id |
+----+
|  2 |
|  4 |
+----+
方法：使用 JOIN 和 DATEDIFF() 子句

算法

MySQL 使用 DATEDIFF 来比较两个日期类型的值。
因此，我们可以通过将 weather 与自身相结合，并使用 DATEDIFF() 函数。
*/

SELECT w1.Id
FROM Weather w1
    JOIN Weather w2 ON DATEDIFF(w1.RecordDate,w2.RecordDate) = 1 AND w1.Temperature > w2.Temperature