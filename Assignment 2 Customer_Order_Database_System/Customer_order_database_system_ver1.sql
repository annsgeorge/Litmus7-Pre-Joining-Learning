-- Part 1
-- Customers Table
CREATE TABLE Customers(	Customer_id INT PRIMARY KEY,Name VARCHAR(150) NOT NULL,
Email VARCHAR(100) UNIQUE NOT NULL,
City VARCHAR(50) NOT NULL,
Signup_date DATE NOT NULL);

-- Orders Table
CREATE TABLE Orders(
Order_id INT PRIMARY KEY,
Customer_id INT,
Order_date DATE NOT NULL,
Total_amount DECIMAL(10,2) NOT NULL ,
CONSTRAINT fk_customer_order_id FOREIGN KEY (Customer_id) REFERENCES Customers(Customer_id) ON DELETE SET NULL);

-- Products Table
CREATE TABLE Products(
Product_id INT PRIMARY KEY,
Product_name VARCHAR(100),
Category VARCHAR(50),
Price DECIMAL(10,2));

--  OrderDetails Table
CREATE TABLE  Orderdetails(
Orderdetail_id INT PRIMARY KEY,
Order_id INT,
Product_id INT,
Quantity INT NOT NULL,
Price DECIMAL(10,2) NOT NULL,
FOREIGN KEY (Order_id) REFERENCES Orders(Order_id),
CONSTRAINT fk_orderdetails_id FOREIGN KEY (Product_id) REFERENCES Products(Product_id)
);

-- Inserting values into Customers Table
INSERT INTO Customers VALUES(100,'Ravi Shankar','ravi@gmail.com','Bangalore','2023-02-10');
INSERT INTO Customers VALUES(101,'Aby Joseph','aby1@gmail.com','Mysore','2023-12-16');
INSERT INTO Customers VALUES(102,'Shiv Shankar','sshankar@gmail.com','Mysore','2024-05-26');
INSERT INTO Customers VALUES(103,'Anna Thomas','annat@gmail.com','Bangalore','2024-02-10');
INSERT INTO Customers VALUES(104,'Jojo Mathew','mjojo@gmail.com','Chennai','2024-08-11');
INSERT INTO Customers VALUES(105,'Any Xavier','any@gmail.com','Mumbai','2025-01-04');

-- Inserting values into Orders Table
INSERT INTO Orders VALUES (500,101,'2024-03-14',49999.87); 
INSERT INTO Orders VALUES (501,104,'2024-07-12',10000.00);
INSERT INTO Orders VALUES (502,101,'2024-08-24',60000.00);
INSERT INTO Orders VALUES (503,102,'2024-08-27',40000.00);
INSERT INTO Orders VALUES (504,103,'2024-09-24',65000.00);
INSERT INTO Orders VALUES (505,103,'2025-05-24',40000.00);

-- Inserting values into Products Table
INSERT INTO Products VALUES(001,'smart tv','electronic gadget',65000.00);
INSERT INTO Products VALUES(002,'samasung galaxy','mobile phone',40000.00);
INSERT INTO Products VALUES(003,'washing machine','electronic gadget',65000.00);
INSERT INTO Products VALUES(004,'bike','vehicle',10000.00);
INSERT INTO Products VALUES(005,'microwave oven','electronic gadget',60000.00);


-- Inserting vlues into OrderDetails Table
INSERT INTO Orderdetails VALUES(1001,503,002,1,40000.00);
INSERT INTO Orderdetails VALUES(1002,502,005,1,60000.00);
INSERT INTO Orderdetails VALUES(1003,505,002,1,40000.00);


-- Part 2
--  Basic Queries
-- 1. Get the list of all Customers
SELECT Customer_id,Name,Email,City,Signup_date FROM Customers;
-- 2. Find all Orders placed in the last 30 days.
SELECT Order_id,Customer_id,Order_date,Total_amount FROM Orders WHERE Order_date >= CURDATE() -INTERVAL 30 DAY;
-- 3. Show product names and their prices
SELECT Product_name,Price FROM Products;
-- 4. Find the total number of Products in each category.
SELECT COUNT(Product_id) AS Count,Category FROM Products GROUP BY Category;

--   Filtering and Conditions
-- 5. Get all Customers FROM the city 'Mumbai'.
SELECT Customer_id,Name,Email,City,Signup_date  FROM Customers WHERE City='Mumbai';
-- 6. Find Orders with a total amount greater than ₹5000
SELECT Order_id,Customer_id,Order_date,Total_amount FROM Orders WHERE Total_amount >= 5000;
-- 7. List Customers who signed up after '2024-01-01'.
SELECT Customer_id,Name,City,Signup_date FROM Customers WHERE SignupDate >'2024-01-01';


--     Joins
-- 8. Show all Orders along with the customer's name.
SELECT Orders.Order_id,Orders.Customer_id,Customers.Name FROM Orders JOIN Customers ON Customers.Customer_id = Orders.Customer_id;
--  9. List Products purchased in each order.
SELECT Orderdetails.Order_id,Orderdetails.Product_id,Orderdetails.Quantity,Products.Product_name,Products.CAtegory FROM Orderdetails JOIN
Products on Products.Product_id =Orderdetails.Product_id;
-- 10. Find Customers who have never placed an order.
SELECT Customers.Customer_id,Customers.Name FROM Customers WHERE Customer_id NOT IN(SELECT Customer_id FROM Orders);


--   Aggregation and Grouping
-- 11. Find the total amount spent by each customer.
SELECT Customers.Customer_id,Customers.Name,SUM(Orders.Total_amount) As Total_amount FROM Customers JOIN Orders on 
Customers.Customer_id = Orders.Customer_id GROUP By Customer_id; 
-- 12. Which product has been sold the most (by quantity)?
SELECT SUM(Orderdetails.Quantity) As MaxQuantity,Orderdetails.Product_id,Products.Product_name FROM Orderdetails JOIN Products
 ON Orderdetails.Product_id = Products.Product_id GROUP BY Product_id;
-- 13. Find the average order value for each customer.
SELECT AVG(Orders.Total_amount) As Average,Customers.Name FROM Orders JOIN Customers on Orders.Customer_id = Customers.Customer_id
GROUP By  Customers.Customer_id;

-- 14. Total sales amount per product category.
SELECT SUM(Orders.Total_amount),Products.Category FROM Orders JOIN Orderdetails on 
Orderdetails.Order_id = Orders.Order_id JOIN Products on Orderdetails.Product_id = Products.Product_id GROUP By Products.Category;

--  Subqueries
-- 15. Find Customers who spent more than the average spending.
SELECT Customers.Name,Orders.Total_amount FROM Customers JOIN Orders on 
Customers.Customer_id = Orders.Customer_id WHERE Orders.Total_amount > (SELECT AVG(Total_amount) FROM Orders) ;
-- 16. List Products that have never been ordered.
SELECT Product_name FROM Products WHERE Product_id NOT IN(SELECT  Product_id FROM Orderdetails);

-- 17. Find the most recent order for each customer.
SELECT Customer_id,MAX(ORderDate) FROM Orders GROUP By Customer_id;

-- Advanced Queries
-- 18. Rank Customers by total spending (highest first).
SELECT Customers.Name ,SUM(Orders.Total_amount) As Total_spent FROM Customers JOIN Orders on 
Customers.Customer_id = Orders.Customer_id  GROUP By Customers.Customer_id ORDER BY Total_spent DESC;

-- 19. Get the top 3 Customers based on the number of Orders placed.
SELECT Customers.Name ,COUNT(Orders.Order_id) As No_of_Orders FROM Customers JOIN Orders on Customers.Customer_id =
Orders.Customer_id GROUP By Customers.Customer_id ORDER BY No_of_Orders DESC LIMIT 3;

-- 20. For each product, find how many unique Customers have purchased it.
SELECT Orderdetails.Product_id ,COUNT(DISTINCT Orders.Customer_id) As Total_purchase FROM Orderdetails JOIN Orders on 
Orderdetails.Order_id = Orders.Order_id GROUP By Orderdetails.Product_id;