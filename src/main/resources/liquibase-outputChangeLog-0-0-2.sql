INSERT INTO ecommerce.product(sku, name, price) VALUES (1,'Produto A', 10.0);
INSERT INTO ecommerce.product(sku, name, price) VALUES (2,'Produto B', 15.0);
INSERT INTO ecommerce.product(sku, name, price) VALUES (3,'Produto C', 30.0);

INSERT INTO ecommerce.address(id, street, num, extra, zip_code, city, state, country)
	VALUES (1, 'Av. Santa Catarina', 1130, 'Apto 602', '88070-740', 'Florianópolis','SC','BR');
INSERT INTO ecommerce.address(id, street, num, extra, zip_code, city, state, country)
	VALUES (2, 'Rua Lauro Linhares', 465, 'Apto 501', '88240-080', 'Florianópolis','SC','BR');

INSERT INTO ecommerce.user(id, username, password, address_id) VALUES(1, 'gustavo.souza','123', 1);
INSERT INTO ecommerce.user(id, username, password, address_id) VALUES(2, 'vitor.gomes','321', 2);