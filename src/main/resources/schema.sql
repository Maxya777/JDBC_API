CREATE TABLE customers
(
    id serial PRIMARY KEY,
    name varchar(64) NOT NULL,
    surname varchar(64) NOT NULL,
    age int NOT NULL,
    phone_number varchar(32) NOT NULL
);

CREATE TABLE orders
(
    id serial PRIMARY KEY,
    date varchar(16) NOT NULL,
    customer_id int REFERENCES customers(id),
    product_name varchar(64) NOT NULL,
    amount int NOT NULL
);

CREATE TABLE persons
(
    name varchar(128) NOT NULL,
    surname varchar(128) NOT NULL,
    age int NOT NULL,
    phone_number varchar NOT NULL,
    city_of_living text NOT NULL,
    PRIMARY KEY(name, surname, age)
);