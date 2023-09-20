INSERT INTO sc_divideai.tbl_person (id, name, total_to_pay,  order_value) VALUES (1, 'Joel Victor', 90.00, 100.00);
INSERT INTO sc_divideai.tbl_person (id, name, total_to_pay,  order_value) VALUES (2, 'Eli Alves', 70.00, 80.00);
INSERT INTO sc_divideai.tbl_person (id, name, total_to_pay,  order_value) VALUES (3, 'Lucas Galvao', 27.55, 30.00);
INSERT INTO sc_divideai.tbl_person (id, name, total_to_pay,  order_value) VALUES (4, 'Matheus Carvalho', 150.00, 145.00);

INSERT INTO sc_divideai.tbl_order (id, discount, payment_method, tax, total_to_pay, total_value, person_id) VALUES (1, 20.00, 1, 8, 12, 28.00, 1);
INSERT INTO sc_divideai.tbl_order (id, discount, payment_method, tax, total_to_pay, total_value, person_id) VALUES (2, 30.00, 2, 9.57, 20.00, 38.00, 2);
INSERT INTO sc_divideai.tbl_order (id, discount, payment_method, tax, total_to_pay, total_value, person_id) VALUES (3, 40.00, 0, 3.99, 30.00, 48.00, 3);
INSERT INTO sc_divideai.tbl_order (id, discount, payment_method, tax, total_to_pay, total_value, person_id) VALUES (4, 50.00, 2, 10.07, 40.00,58.00, 4);
