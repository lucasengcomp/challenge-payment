-- sc_divideai.tbl_order
COMMENT ON COLUMN sc_divideai.tbl_order.discount IS 'Discount applied to the order.';
COMMENT ON COLUMN sc_divideai.tbl_order.payment_method IS 'Payment method for the order (1: Pix, 2: Card, 3: Money).';
COMMENT ON COLUMN sc_divideai.tbl_order.tax IS 'Tax associated with the order.';
COMMENT ON COLUMN sc_divideai.tbl_order.total_to_pay IS 'Total amount to be paid for the order.';
COMMENT ON COLUMN sc_divideai.tbl_order.total_value IS 'Total value of the order.';
COMMENT ON COLUMN sc_divideai.tbl_order.id IS 'Primary key for the order table.';
COMMENT ON COLUMN sc_divideai.tbl_order.person_id IS 'Foreign key referencing the person associated with the order.';

-- sc_divideai.tbl_person
COMMENT ON COLUMN sc_divideai.tbl_person.order_value IS 'Value associated with the persons order.';
COMMENT ON COLUMN sc_divideai.tbl_person.total_to_pay IS 'Total amount to be paid by the person.';
COMMENT ON COLUMN sc_divideai.tbl_person.id IS 'Primary key for the person table.';
COMMENT ON COLUMN sc_divideai.tbl_person.name IS 'Name of the person.';
