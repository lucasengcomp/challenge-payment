-- Adicionando restrições de chave estrangeira

ALTER TABLE
    IF EXISTS sc_divideai.tbl_item
    ADD
    CONSTRAINT FKf0xig0e3v25d0s9u6r9p6hoq4 FOREIGN KEY (person_id) REFERENCES sc_divideai.tbl_person;

ALTER TABLE
    IF EXISTS sc_divideai.tbl_order_people
    ADD
    CONSTRAINT FKhrq8sh1byqvkr4mrb38diuto FOREIGN KEY (people_id) REFERENCES sc_divideai.tbl_person;

ALTER TABLE
    IF EXISTS sc_divideai.tbl_order_people
    ADD
    CONSTRAINT FKqgj5q78vufvwvkj2kjhnjc0jy FOREIGN KEY (order_id) REFERENCES sc_divideai.tbl_order;

ALTER TABLE
    IF EXISTS sc_divideai.tbl_person_items
    ADD
    CONSTRAINT FKkau7jtf8gtsu0ud4ag57k5074 FOREIGN KEY (items_id) REFERENCES sc_divideai.tbl_item;

ALTER TABLE
    IF EXISTS sc_divideai.tbl_person_items
    ADD
    CONSTRAINT FKd2jes74b3d35tf0b57gfr8fpu FOREIGN KEY (person_id) REFERENCES sc_divideai.tbl_person;
