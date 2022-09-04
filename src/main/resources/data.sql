INSERT INTO brand (name) VALUES ('ZARA');
INSERT INTO brand (name) VALUES ('ZARA HOME');

INSERT INTO product (code, name) VALUES (35455, 'Camisa');
INSERT INTO product (code, name) VALUES (35456, 'Remera');

INSERT INTO prices (brand_id, start_date, end_date,price_list,product_id,priority,price,curr)
VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1 , 1, 0, 35.50, 'EUR');

INSERT INTO prices (brand_id, start_date, end_date,price_list,product_id,priority,price,curr)
VALUES (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2 , 1, 1, 25.45, 'EUR');

INSERT INTO prices (brand_id, start_date, end_date,price_list,product_id,priority,price,curr)
VALUES (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3 , 1, 1, 30.50, 'EUR');

INSERT INTO prices (brand_id, start_date, end_date,price_list,product_id,priority,price,curr)
VALUES (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4 , 1, 1, 30.50, 'EUR');
