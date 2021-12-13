### Online gardening store

For this project, assume that you are building an application for an online gardening store. Work in pairs to complete the activity below. Proactively seek help from your peers and your instructor if you feel stuck.
1. Create a database with the following tables and add some additional data:

DROP TABLE IF EXISTS department_garden;

CREATE TABLE department_garden (
id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
department VARCHAR(255)
);

DROP TABLE IF EXISTS product_garden;

CREATE TABLE product_garden (
id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
department_id INT,
name VARCHAR(255),
quantity INT,
FOREIGN KEY (department_id) REFERENCES department_garden (id)
);

INSERT INTO department_garden (department) VALUES
("tools"),("edible plants"),("non-edible plants"),("edible seeds"),("non-edible seeds"),("miscellaneous");

INSERT INTO product_garden (department_id, name, quantity) VALUES
(1,"small shovel", 50),
(1,"large shovel", 150),
(2,"apple tree sapling", 10),
(4,"assorted root vegetable seed packet", 2000),
(5,"geranium seed packet", 1000),
(2,"sprouted carrots", 200),
(6,"large brim gardering hat", 25);


2. Create a route for adding new products (validate the payload format)
3. Create a route for decrementing the quantity of a product by an amount specified in a parameter. 
   Throw a custom error and respond with an appropriate response code if the specified amount is less than the quantity 
   of the product in stock. 
4. Create a route to get all products by department. Return all products if the department param is empty/null. 
5. Create a route to get a product by id. Throw an error and respond with an appropriate response code if the id does 
   not exist. 
6. Create a route to add a new department (validate the payload format)
7. Create a DELETE route to delete products from the product list by id. 
8. Test all of your routes thoroughly.