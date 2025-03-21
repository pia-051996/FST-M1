
--Activity6
SELECT * FROM ORDERS;

SELECT DISTINCT SALESMAN_ID FROM ORDERS;

SELECT ORDER_NO,ORDER_DATE from ORDERS ORDER BY ORDER_DATE ASC;

SELECT ORDER_NO,PURCHASE_AMOUNT from ORDERS ORDER BY PURCHASE_AMOUNT DESC;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT < 500;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT BETWEEN 1000 AND 2000;

--Activity7

-- Write an SQL statement to find the total purchase amount of all orders.
--Write an SQL statement to find the average purchase amount of all orders.
    --Write an SQL statement to get the maximum purchase amount of all the orders.
--Write an SQL statement to get the minimum purchase amount of all the orders.
--Write an SQL statement to find the number of salesmen listed in the table.

SELECT SUM(PURCHASE_AMOUNT) as "Total Sum" from orders;

SELECT AVG(PURCHASE_AMOUNT) as "Avg purchase amt" from orders;

SELECT MAX(PURCHASE_AMOUNT) as "Max amt" from orders;

SELECT MIN(PURCHASE_AMOUNT) as "Min amt" from orders;

SELECT COUNT(distinct SALESMAN_ID) as "Total Count" from orders;

--Activity8
SELECT customer_id, MAX(PURCHASE_AMOUNT) AS "Max Amount" FROM ORDERS
GROUP BY CUSTOMER_ID;

--Write an SQL statement to find the highest purchase amount 
--on '2012-08-17' for each salesman with their ID.

SELECT SALESMAN_ID, ORDER_DATE, MAX(PURCHASE_AMOUNT) AS "Max amount" from orders
WHERE ORDER_DATE = To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id,ORDER_DATE;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
GROUP BY customer_id, order_date 
HAVING MAX(PURCHASE_AMOUNT) IN (2030,3450,5760,6000);

