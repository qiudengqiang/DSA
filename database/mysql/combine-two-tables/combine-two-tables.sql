/*
https://leetcode-cn.com/problems/combine-two-tables/

表1: Person

+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId 是上表主键
表2: Address

+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId 是上表主键
 

编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：

 FirstName, LastName, City, State
*/
--错误写法：
SELECT FirstName,LastName,City,State
FROM Person p,Address a 
WHERE p.PersonId = a.PersonId;

--错在哪里？因为地址可能为空，但是Person的基本信息在地址为空时后是要显示的，如果使用WHERE当地址为空时直接连基本的信息都会过滤掉

--正确写法：
SELECT FirstName,LastName,City,State 
FROM Person p LEFT JOIN Address a
ON p.PersonId = a.PersonId;

