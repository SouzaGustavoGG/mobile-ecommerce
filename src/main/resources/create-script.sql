CREATE SCHEMA IF NOT EXISTS ecommerce AUTHORIZATION postgres;

DROP TABLE IF EXISTS ecommerce.address;
CREATE TABLE ecommerce.address(
	id INTEGER PRIMARY KEY,
	street VARCHAR,
	num INTEGER,
	extra VARCHAR,
	zip_code VARCHAR,
	state VARCHAR(60),
	city VARCHAR(60),
	country varchar(50)
);


DROP TABLE IF EXISTS ecommerce.user;
CREATE TABLE  ecommerce.user(
	id INTEGER PRIMARY KEY,
	username VARCHAR UNIQUE NOT NULL,
	password VARCHAR NOT NULL,
	address_id INTEGER,
	FOREIGN KEY (address_id) REFERENCES ecommerce.address (id)
);

DROP TABLE IF EXISTS ecommerce.product;
CREATE TABLE ecommerce.product(
	sku INTEGER PRIMARY KEY,
	name VARCHAR,
	price DOUBLE PRECISION
);

DROP TABLE IF EXISTS ecommerce.item;
CREATE TABLE ecommerce.item(
	id INTEGER PRIMARY KEY,
	quantity INTEGER NOT NULL,
	product_id INTEGER,
	FOREIGN KEY (product_id) REFERENCES ecommerce.product (sku)
);

DROP TABLE IF EXISTS ecommerce.order;
CREATE TABLE  ecommerce.order(
	id SERIAL PRIMARY KEY,
	create_date DATE NOT NULL,
	total DOUBLE PRECISION,
	user_id INTEGER,
	FOREIGN KEY (user_id) REFERENCES ecommerce.user (id)
);


DROP TABLE IF EXISTS ecommerce.order_item;
CREATE TABLE ecommerce.order_item(
	order_id INTEGER,
	item_id INTEGER,
	FOREIGN KEY (order_id) REFERENCES ecommerce.order (id),
	FOREIGN KEY (item_id) REFERENCES ecommerce.item (id)
);