/*
https://leetcode-cn.com/problems/not-boring-movies/
某城市开了一家新的电影院，吸引了很多人过来看电影。该电影院特别注意用户体验，专门有个 LED显示板做电影推荐，上面公布着影评和相关电影描述。

作为该电影院的信息部主管，您需要编写一个 SQL查询，找出所有影片描述为非 boring(不无聊) 的并且 id 为奇数 的影片，结果请按等级 rating 排列。


例如，下表
cinema:

+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   1     | War       |   great 3D   |   8.9     |
|   2     | Science   |   fiction    |   8.5     |
|   3     | irish     |   boring     |   6.2     |
|   4     | Ice song  |   Fantacy    |   8.6     |
|   5     | House card|   Interesting|   9.1     |
+---------+-----------+--------------+-----------+
对于上面的例子，则正确的输出是为：

+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   5     | House card|   Interesting|   9.1     |
|   1     | War       |   great 3D   |   8.9     |
+---------+-----------+--------------+-----------+

方法：使用 MOD() 函数算法

我们可以使用 mod(id,2)=1 来确定奇数 id，然后添加 description != 'boring' 来解决问题。

*/

--官方解法 击败39.81%的用户
select *
from cinema
where mod(id, 2) = 1 and description != 'boring'
order by rating DESC;

--我的解法 击败90.84% 的用户，利用了临时派生表优化
SELECT *
FROM (SELECT *
    FROM cinema
    WHERE description != 'boring') cima
WHERE mod(id, 2) = 1
ORDER BY rating DESC;