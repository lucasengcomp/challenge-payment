-- Tabela para armazenar itens do Pedido
COMMENT ON COLUMN sc_divideai.tbl_item.id IS 'Identificador único para o item.';
COMMENT ON COLUMN sc_divideai.tbl_item.price IS 'Preço do item (até 8 dígitos com 2 casas decimais).';
COMMENT ON COLUMN sc_divideai.tbl_item.description IS 'Descrição do item (até 100 caracteres).';
COMMENT ON COLUMN sc_divideai.tbl_item.person_id IS 'Identificador da pessoa associada a este item.';

-- Tabela para armazenar Pedido
COMMENT ON COLUMN sc_divideai.tbl_order.id IS 'Identificador único do pedido.';
COMMENT ON COLUMN sc_divideai.tbl_order.discount IS 'Desconto aplicado ao pedido.';
COMMENT ON COLUMN sc_divideai.tbl_order.tax IS 'Taxa associada ao pedido.';
COMMENT ON COLUMN sc_divideai.tbl_order.total IS 'Valor total do pedido.';
COMMENT ON COLUMN sc_divideai.tbl_order.total_to_pay IS 'Valor total a ser pago pelo pedido.';

-- Tabela para armazenar informações da Pessoa
COMMENT ON COLUMN sc_divideai.tbl_person.id IS 'Identificador único da pessoa.';
COMMENT ON COLUMN sc_divideai.tbl_person.cpf IS 'CPF da pessoa (até 14 caracteres).';
COMMENT ON COLUMN sc_divideai.tbl_person.name IS 'Nome da pessoa (até 100 caracteres).';
COMMENT ON COLUMN sc_divideai.tbl_person.total_to_pay IS 'Valor total a ser pago pela pessoa.';
COMMENT ON COLUMN sc_divideai.tbl_person.total_payment IS 'Valor total já pago pela pessoa.';
COMMENT ON COLUMN sc_divideai.tbl_person.payment_method IS 'Método de pagamento para a pessoa (1: Pix, 2: Cartão, 3: Dinheiro).';

-- Tabela de associação entre Pedidos e Pessoas
COMMENT ON COLUMN sc_divideai.tbl_order_people.order_id IS 'Identificador do pedido na associação.';
COMMENT ON COLUMN sc_divideai.tbl_order_people.people_id IS 'Identificador único da pessoa na associação.';

-- Tabela de associação entre Itens e Pessoas
COMMENT ON COLUMN sc_divideai.tbl_person_items.items_id IS 'Identificador único do item na associação.';
COMMENT ON COLUMN sc_divideai.tbl_person_items.person_id IS 'Identificador da pessoa na associação.';
