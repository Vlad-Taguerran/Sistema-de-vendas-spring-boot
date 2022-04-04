CREATE TABLE Customers (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE Products (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    price NUMERIC (20,2)
);
CREATE TABLE Orders (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    CUSTOMERS_ID INT  REFERENCES Customers(ID),
    order_date TIMESTAMP,
    total NUMERIC(20,2)
);
CREATE TABLE Order_itens (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT  REFERENCES Orders(ID),
    product_ID INT  REFERENCES Products(ID),
    amount INT,
    order_date TIMESTAMP,
    total NUMERIC(20,2)
);
