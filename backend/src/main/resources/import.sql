INSERT INTO sc_divideai.tbl_person (name, cpf, total_to_pay, total_payment, payment_method) VALUES ('Joel Victor', '111.222.333-44', 100, 95, 'MONEY');
INSERT INTO sc_divideai.tbl_person (name, cpf, total_to_pay, total_payment, payment_method) VALUES ('Eli Alves', '222.333.444-55', 90, 85, 'PIX');
INSERT INTO sc_divideai.tbl_person (name, cpf, total_to_pay, total_payment, payment_method) VALUES ('Lucas Galvao', '444.333.222-11', 65, 60, 'PIX');
INSERT INTO sc_divideai.tbl_person (name, cpf, total_to_pay, total_payment, payment_method) VALUES ('Matheus Carvalho', '888.555.333-11', 45, 40, 'CARD');

INSERT INTO sc_divideai.tbl_order(discount, tax, total_to_pay, total) VALUES (8, 20, 38, 50);
INSERT INTO sc_divideai.tbl_order(discount, tax, total_to_pay, total) VALUES (8, 20, 58, 150);

INSERT INTO sc_divideai.tbl_item(price, person_id, description) VALUES (40, 1, 'Hamburger');
INSERT INTO sc_divideai.tbl_item(price, person_id, description) VALUES (2, 1, 'Sobremesa');
INSERT INTO sc_divideai.tbl_item(price, person_id, description) VALUES (8, 3, 'Sanduiche');
INSERT INTO sc_divideai.tbl_item(price, person_id, description) VALUES (5, 2, 'Coca Cola');
INSERT INTO sc_divideai.tbl_item(price, person_id, description) VALUES (3, 2, 'Água');

INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (1, 1);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (2, 1);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (3, 1);

INSERT INTO sc_divideai.tbl_order_people(order_id, people_id) VALUES (1, 1);
INSERT INTO sc_divideai.tbl_order_people(order_id, people_id) VALUES (1, 2);
