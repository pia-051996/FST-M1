
-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

--Activity9

--Write an SQL statement to know which salesman are working for which customer.
SELECT s.SALESMAN_ID, c.customer_id,s.SALESMAN_NAME,C.CUSTOMER_NAME FROM CUSTOMERS C 
INNER JOIN SALESMAN S
on C.SALESMAN_ID=s.SALESMAN_ID;


--Write an SQL statement to make a list of customers in ascending order with a salesman that have a grade less than 300.
SELECT C.CUSTOMER_NAME,C.CUSTOMER_CITY, s.SALESMAN_NAME FROM CUSTOMERS C 
LEFT OUTER JOIN SALESMAN s
ON C.SALESMAN_ID = S.SALESMAN_ID
WHERE c.GRADE < 300
ORDER BY C.CUSTOMER_ID;


--Write an SQL statement to find the list of customers who appointed a salesman who gets a commission of more than 12%.
SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a 
INNER JOIN salesman b ON a.salesman_id=b.salesman_id 
WHERE b.commission>12;

--Write an SQL statement to find the following details of an order - order number, order date, purchase amount of order, which customer gives the order and which salesman works for that customer and commission rate they get for the order.
SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

--Activity10

--Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT * FROM orders
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

-- Write a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

--Write a query to count the customers with grades above New York's average.
SELECT * FROM CUSTOMERS;

SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');


--Write a query to extract the data from the orders table for those salesman who earned the maximum commission
select * from orders
where salesman_id in (select salesman_id from salesman where commission = (select max(COMMISSION) from salesman));

--Activity11
-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

-- Write a query to make a report of which salesman produce the largest and smallest orders on each date.
SELECT a.salesman_id, a.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
ORDER BY order_date;