-- 从 Products 表中检索所有的产品名称以及对应的销售总数
SELECT
    p.prod_name,
    sum( o.quantity ) AS quant_sold
FROM
    Products p,
    OrderItems o
WHERE
        p.prod_id = o.prod_id
GROUP BY-- 要排的 根据什么关键词对相关的行group by
        p.prod_name;


-- 返回顾客名称和相关订单号
SELECT
    cust_name,
    order_num
FROM
    Customers c
        INNER JOIN Orders o ON c.cust_id = o.cust_id
ORDER BY
    cust_name,
    order_num;


--  返回顾客名称和相关订单号以及每个订单的总价
SELECT
    c.cust_name,
    o.order_num,
    sum( item_price * quantity ) AS OrderTotal
FROM
    Customers c
        LEFT JOIN Orders o ON c.cust_id = o.cust_id
        LEFT JOIN OrderItems oi ON o.order_num = oi.order_num
GROUP BY
    cust_name, o.order_num
ORDER BY
    cust_name,
    order_num


-- 确定哪些订单购买了 prod_id 为 BR01 的产品（二）
SELECT
    cust_id,
    order_date
FROM
    Orders o
        JOIN OrderItems oi ON o.order_num = oi.order_num
WHERE
        prod_id = "BR01"
ORDER BY
    order_date;


-- 返回购买 prod_id 为 BR01 的产品的所有顾客的电子邮件（二）
SELECT
    cust_email
FROM
    OrderItems oi
        INNER JOIN Orders o ON oi.order_num = o.order_num
        INNER JOIN Customers c ON c.cust_id = orders.cust_id
WHERE
        oi.prod_id = "BR01";


-- 确定最佳顾客的另一种方式（二）
select
    cust_name,
    sum(item_price * quantity)
from
    OrderItems oi
        INNER JOIN Orders o on oi.order_num = o.order_num
        INNER JOIN Customers c on c.cust_id = o.cust_id
GROUP BY cust_name, oi.order_num
having sum(item_price * quantity) > 1000;


-- 检索每个顾客的名称和所有的订单号（一）
-- 所有关联的
select
    cust_name,
    order_num
from
    Customers c
        inner join Orders o
                   on
                           c.cust_id = o.cust_id
order by
    cust_name;


-- 检索每个顾客的名称和所有的订单号（二）
-- 【问题】检索每个顾客的名称（Customers表中的 cust_name）和所有的订单号（Orders 表中的 order_num），列出所有的顾客，即使他们没有下过订单。最后根据顾客姓名cust_name升序返回。
select
    cust_name,
    order_num
from
    Customers c
        left join Orders o on c.cust_id = o.cust_id
order by
    cust_name;


-- 返回产品名称和与之相关的订单号
select
    prod_name, order_num
from
    Products p
        left join OrderItems oi on p.prod_id = oi.prod_id
order by
    prod_name;


-- 返回产品名称和每一项产品的总订单数
select
    prod_name,
    count(order_num)
from
    Products p
        left join OrderItems oi on p.prod_id = oi.prod_id
group by
    prod_name
order by
    prod_name


-- 列出供应商及其可供产品的数量
select
    v.vend_id,
    count(prod_id)
from
    Vendors v
        left join Products p on v.vend_id = p.vend_id
group by v.vend_id
order by v.vend_id;


-- 将两个 SELECT 语句结合起来（一）
SELECT
    *
FROM
    OrderItems
WHERE
        quantity = 100 UNION ALL
SELECT
    *
FROM
    OrderItems
WHERE
        prod_id LIKE 'BNBG%'
ORDER BY
    prod_id


-- 将两个 SELECT 语句结合起来（二）
select
    *
from
    OrderItems
where

    (prod_id like 'BNBG%') or (quantity = 100)
order by
    prod_id;
