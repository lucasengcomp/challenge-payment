INSERT INTO sc_divideai.tbl_person (name, cpf) VALUES ('Joel Victor', '111.222.333-44');
INSERT INTO sc_divideai.tbl_person (name, cpf) VALUES ('Eli Alves', '222.333.444-55');
INSERT INTO sc_divideai.tbl_person (name, cpf) VALUES ('Lucas Galvao', '444.333.222-11');
INSERT INTO sc_divideai.tbl_person (name, cpf) VALUES ('Matheus Carvalho', '888.555.333-11');

INSERT INTO sc_divideai.tbl_item(price, description) VALUES (40, 'Hamburger');
INSERT INTO sc_divideai.tbl_item(price, description) VALUES (2, 'Sobremesa');
INSERT INTO sc_divideai.tbl_item(price, description) VALUES (8, 'Sanduiche');
INSERT INTO sc_divideai.tbl_item(price, description) VALUES (5, 'Coca Cola');
INSERT INTO sc_divideai.tbl_item(price, description) VALUES (3, 'Água');

INSERT INTO sc_divideai.tbl_order(discount, payment_method, tax, total_to_pay, total, person_id) VALUES (8, 1, 0, 38, 50, 1);
INSERT INTO sc_divideai.tbl_order(discount, payment_method, tax, total_to_pay, total, person_id) VALUES (8, 1, 0, 38, 50, 2);

INSERT INTO sc_divideai.tbl_order_items(items_id, order_id) VALUES (1, 1);
INSERT INTO sc_divideai.tbl_order_items(items_id, order_id) VALUES (2, 1);
INSERT INTO sc_divideai.tbl_order_items(items_id, order_id) VALUES (3, 1);

