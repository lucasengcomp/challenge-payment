INSERT INTO sc_divideai.tbl_person (name, cpf, total, total_to_pay, payment_method) VALUES ('Tony Stark', '111.222.333-44', 134.99, 132.28, 'MONEY');
INSERT INTO sc_divideai.tbl_person (name, cpf, total, total_to_pay, payment_method) VALUES ('Harry Potter', '222.333.444-55', 90.00, 85.00, 'CARD');
INSERT INTO sc_divideai.tbl_person (name, cpf, total, total_to_pay, payment_method) VALUES ('Alvo Percival Wulfrico Brian Dumbledore', '444.333.222-11', 65.00, 60.00, 'PIX');
INSERT INTO sc_divideai.tbl_person (name, cpf, total, total_to_pay, payment_method) VALUES ('Jack Sparrow', '888.555.333-11', 45.00, 40.00, 'CARD');

INSERT INTO sc_divideai.tbl_order(discount, tax, total_to_pay, total, type_meal) VALUES (10.00, 5.00, 243.99, 248.99, 'DELIVER');
INSERT INTO sc_divideai.tbl_order(percentage_fee_waiter, total, total_to_pay, type_meal) VALUES (15.75, 214.74, 248.56, 'RESTAURANT');

--Pedido 1 Tony Stark
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (42.00, 'Hamburger', 1);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (8.00, 'Refrigerante', 1);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (15.99, 'Batata', 1);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (69.99, 'Combo casal', 1);

--Pedido 1 Harry Potter
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (75.00, 'Barca de sanduiche', 2);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (21.00, 'Kebab', 2);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (18.00, 'Shawarma', 2);

-- Pedido 2 Alvo Dumbledore
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (25.99, 'Nachos', 3);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (35.79, 'Ravioli', 3);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (23.99, 'Arancino', 3);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (12.00, 'Brownie', 3);

-- Pedido 2 Jack Sparrow
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (29.99, 'Açaí', 3);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (36.79, 'Camarão', 3);
INSERT INTO sc_divideai.tbl_item(price, description, person_id) VALUES (49.99, 'Peixe frito', 3);

INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (1, 1);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (2, 1);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (3, 1);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (4, 1);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (5, 2);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (6, 2);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (7, 2);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (8, 3);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (9, 3);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (10, 3);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (11, 3);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (12, 4);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (13, 4);
INSERT INTO sc_divideai.tbl_person_items(items_id, person_id) VALUES (14, 4);

