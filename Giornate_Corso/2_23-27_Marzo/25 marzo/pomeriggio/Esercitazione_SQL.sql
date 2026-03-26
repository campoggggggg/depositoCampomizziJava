--Esercizio 1

--Esercizio 2

--Esercizio 3
SELECT c.Name AS Country, c.LifeExpectancy AS Exp_life, CL.Language
FROM country AS c
INNER JOIN countrylanguage AS cl
ON c.Code = cl.CountryCode
WHERE c.LifeExpectancy >= 70 AND c.GovernmentForm LIKE "%republic%"
ORDER BY c.LifeExpectancy ASC;

--Esercizio 4
SELECT cust.customerName AS Customer,
	cust.contactFirstName AS Name,
    cust.contactLastName AS Surname,
    pay.paymentDate AS Date_of_payment,
    pay.amount AS Amount_of_payment
FROM customers AS cust
INNER JOIN payments AS pay 
	ON cust.customerNumber = pay.customerNumber
ORDER BY pay.paymentDate DESC;

--Esercizio 5
--con il JOIN
SELECT cust.customerNumber AS Customer_ID,
	cust.customerName AS Customer,
    orders.orderNumber AS Order_ID
FROM customers AS cust
LEFT JOIN orders 
	ON cust.customerNumber = orders.customerNumber
WHERE orders.orderNumber IS null;
--con la subquery
SELECT customerNumber AS Customer_ID,
	customerName AS Customer
FROM customers
WHERE customerNumber NOT IN (SELECT customerNumber 
                            	FROM orders);

--Esercizio 6
SELECT emp1.firstName AS Employee_Name,
	emp1.lastName AS Employee_Surname,
    emp2.firstName AS Boss_Name,
    emp2.lastName AS Boss_Surname
FROM employees AS emp1
LEFT JOIN employees AS emp2
	ON emp1.reportsTo = emp2.employeeNumber;

--Esercizio 7
SELECT customers.customerName AS Customer,
	COUNT(orders.customerNumber) AS Tot_Orders --COUNT per vedere il numero di ordini. con SUM hai totale di ordini
FROM customers
INNER JOIN orders 
	ON customers.customerNumber = orders.customerNumber
GROUP BY customers.customerNumber;
