CREATE TABLE sc_divideai.tbl_item (
    id bigserial NOT NULL,
    price NUMERIC(8, 2),
    description VARCHAR(100),
    person_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE sc_divideai.tbl_order (
    id bigserial NOT NULL,
    discount NUMERIC(38, 2),
    tax NUMERIC(38, 2),
    total NUMERIC(8, 2),
    total_to_pay NUMERIC(8, 2),
    PRIMARY KEY (id)
);

CREATE TABLE sc_divideai.tbl_person (
    id bigserial NOT NULL,
    cpf VARCHAR(14),
    name VARCHAR(100) NOT NULL,
    total_to_pay NUMERIC(8, 2),
    total_payment NUMERIC(8, 2),
    payment_method VARCHAR(255) CHECK (payment_method IN ('PIX', 'CARD', 'MONEY')),
    PRIMARY KEY (id)
);

CREATE TABLE sc_divideai.tbl_order_people (
    order_id BIGINT NOT NULL,
    people_id BIGINT NOT NULL UNIQUE
);

CREATE TABLE sc_divideai.tbl_person_items (
    person_id BIGINT NOT NULL,
    items_id BIGINT NOT NULL UNIQUE
);
