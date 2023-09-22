ALTER TABLE sc_divideai.tbl_order
    ADD COLUMN items;

ALTER TABLE sc_divideai.tbl_order
    ADD COLUMN total;

COMMENT ON COLUMN sc_divideai.tbl_order.items IS 'Items order';
COMMENT ON COLUMN sc_divideai.tbl_order.total IS 'Total Order';
