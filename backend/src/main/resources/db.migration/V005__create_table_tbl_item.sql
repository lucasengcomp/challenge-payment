CREATE TABLE sc_divideai.tbl_item (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    price NUMERIC(38, 2) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (id)
);

COMMENT ON COLUMN sc_divideai.tbl_item.id IS 'Primary key for the item table.';
COMMENT ON COLUMN sc_divideai.tbl_item.description IS 'Description of the item.';
COMMENT ON COLUMN sc_divideai.tbl_item.value IS 'Price of the item.';
