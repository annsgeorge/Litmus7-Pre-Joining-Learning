-- Part 1
-- Customers Table
CREATE TABLE Customers(	Customer_id INT PRIMARY KEY,	Name VARCHAR(100) NOT NULL,
Email VARCHAR(100) UNIQUE,
City VARCHAR(50) NOT NULL,
SignupDate DATE NOT NULL);

-- Orders Table
CREATE TABLE Orders(
Order_id INT PRIMARY KEY,
Customer_id INT,
OrderDate DATE,
TotalAmount DECIMAL(10,2),
FOREIGN KEY (Customer_id) REFERENCES Customers(Customer_id) ON DELETE CASCADE);

-- Products Table
CREATE TABLE Products(
Product_id INT PRIMARY KEY,
ProductName VARCHAR(100),
Category VARCHAR(50),
Price DECIMAL(10,2));

--  OrderDetails Table
CREATE TABLE  OrderDetails(
OrderDetail_id INT PRIMARY KEY,
Order_id INT,
Product_id INT,
Quantity INT,
Price DECIMAL(10,2),
FOREIGN KEY (Order_id) REFERENCES Orders(Order_id),
FOREIGN KEY (Product_id) REFERENCES Products(Product_id)
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
INSERT INTO OrderDetails VALUES(1001,503,002,1,40000.00);
INSERT INTO OrderDetails VALUES(1002,502,005,1,60000.00);
INSERT INTO OrderDetails VALUES(1003,505,002,1,40000.00);


-- Part 2
--  Basic Queries
-- 1. Get the list of all Customers
SELECT * FROM Customers;
-- 2. Find all Orders placed in the last 30 days.
SELECT * FROM Orders WHERE OrderDate >= CURDATE() -INTERVAL 30 DAY;
-- 3. Show product names and their prices
SELECT ProductName,Price FROM Products;
-- 4. Find the total number of Products in each category.
SELECT COUNT(Product_id) as count,Category FROM Products group by Category;

--   Filtering and Conditions
-- 5. Get all Customers FROM the city 'Mumbai'.
SELECT * FROM Customers WHERE City='Mumbai';
-- 6. Find Orders with a total amount greater than ₹5000
SELECT * FROM Orders WHERE TotalAmount >= 5000;
-- 7. List Customers who signed up after '2024-01-01'.
SELECT * FROM Customers WHERE SignupDate >'2024-01-01';


--     Joins
-- 8. Show all Orders along with the customer's name.
SELECT Orders.Order_id,Orders.Customer_id,Customers.Name FROM Orders JOIN Customers ON Customers.Customer_id = Orders.Customer_id;
--  9. List Products purchased in each order.
SELECT OrderDetails.Order_id,OrderDetails.Product_id,OrderDetails.Quantity,Products.ProductName,Products.Category FROM OrderDetails JOIN
Products on Products.Product_id =OrderDetails.Product_id;
-- 10. Find Customers who have never placed an order.
SELECT Customers.Customer_id,Customers.name FROM Customers where customer_id not in(SELECT customer_id FROM Orders);


--   Aggregation and Grouping
-- 11. Find the total amount spent by each customer.
SELECT Customers.Customer_id,Customers.Name,sum(Orders.TotalAmount) as TotalAmount FROM Customers join Orders on 
Customers.Customer_id = Orders.Customer_id group by Customer_id; 
-- 12. Which product has been sold the most (by quantity)?
SELECT max(OrderDetails.Quantity) as MaxQuantity,OrderDetails.Product_id,Products.ProductName FROM OrderDetails join Products
 on OrderDetails.Product_id = Products.Product_id group by Product_id;
-- 13. Find the average order value for each customer.
SELECT avg(Orders.TotalAmount) as average,Customers.Name FROM Orders join Customers on Orders.Customer_id = Customers.Customer_id
group by  Customers.Customer_id;

-- 14. Total sales amount per product category.
SELECT sum(Orders.totalamount),Products.Category FROM Orders join OrderDetails on 
OrderDetails.Order_id = Orders.Order_id join Products on OrderDetails.Product_id = Products.Product_id group by Products.Category;

--  Subqueries
-- 15. Find Customers who spent more than the average spending.
SELECT Customers.Name,Orders.TotalAmount FROM Customers join Orders on 
Customers.Customer_id = Orders.Customer_id where Orders.TotalAmount > (SELECT avg(totalamount) FROM Orders) ;
-- 16. List Products that have never been ordered.
SELECT ProductName FROM Products where Product_id not in(SELECT  Product_id FROM OrderDetails);

-- 17. Find the most recent order for each customer.
SELECT Customer_id,max(OrderDate) FROM Orders group by Customer_id;

-- Advanced Queries
-- 18. Rank Customers by total spending (highest first).
SELECT Customers.Name ,sum(Orders.TotalAmount) as TotalSpent FROM Customers join Orders on 
Customers.customer_id = Orders.customer_id  group by Customers.Customer_id order by TotalSpent DESC;

-- 19. Get the top 3 Customers based on the number of Orders placed.
SELECT Customers.Name ,count(Orders.Order_id) as No_of_Orders FROM Customers join Orders on Customers.Customer_id =
Orders.Customer_id group by Customers.Customer_id order by No_of_Orders desc limit 3;

-- 20. For each product, find how many unique Customers have purchased it.
SELECT OrderDetails.Product_id ,count(distinct Orders.Customer_id) as TotalPurchase FROM OrderDetails join Orders on OrderDetails.Order_id = Orders.Order_id
group by OrderDetails.Product_id;