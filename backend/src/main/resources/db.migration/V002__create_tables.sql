CREATE TABLE IF NOT EXISTS sc_divideai.tbl_order (
    discount NUMERIC(38, 2),
    payment_method SMALLINT NOT NULL CHECK (payment_method BETWEEN 0 AND 2),
    tax numeric(38, 2),
    total_to_pay NUMERIC(38, 2) NOT NULL,
    total_value NUMERIC(38, 2) NOT NULL,
    id bigserial NOT NULL,
    person_id bigint,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS sc_divideai.tbl_person (
    order_value NUMERIC(38, 2) NOT NULL,
    total_to_pay NUMERIC(38, 2),
    id bigserial NOT NULL,
    name varchar(50) NOT NULL,
    PRIMARY KEY (id)
);
