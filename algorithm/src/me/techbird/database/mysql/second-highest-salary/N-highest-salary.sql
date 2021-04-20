-- 获取第N高的薪水，利用函数
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N := N-1;
RETURN (
        # Write your MySQL query statement below.
      select distinct(Salary)
       from Employee
       order by Salary desc
       limit N,1
    );
END