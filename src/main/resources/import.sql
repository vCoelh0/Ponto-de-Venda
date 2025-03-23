INSERT INTO tb_cardapio (name, price, description) VALUES ('Filé com Fritas', 25.50, 'Filé bovino com batata frita. Arroz e feijão de acompanhamento');
INSERT INTO tb_cardapio (name, price, description) VALUES ('Burger do Chef', 39.90, '200 gramas de carne, pão brioche, bacon, chedar e molho especial do chef');
INSERT INTO tb_cardapio (name, price, description) VALUES ('Feijoada', 45.90, 'Feijoada completa. Acompanhamentos: Torresmo e arroz');
INSERT INTO tb_cardapio (name, price, description) VALUES ('MilkShake', 19.90, 'Milshake de ovomaltine');
INSERT INTO tb_cardapio (name, price, description) VALUES ('Suco de Laranja', 8.50, 'Suco de laranja natural');
INSERT INTO tb_cardapio (name, price, description) VALUES ('Refrigerante', 7.00, 'Refrigerante de lata 350ML');


INSERT INTO tb_pedido (numero_mesa, data_hora) VALUES (12, '2024-01-05T12:34:45');
INSERT INTO tb_pedido (numero_mesa, data_hora) VALUES (5, '2024-01-05T15:20:10');


INSERT INTO tb_item_pedido (quantidade, cardapio_id, pedido_id) VALUES (2, 1, 1);
INSERT INTO tb_item_pedido (quantidade, cardapio_id, pedido_id) VALUES (1, 2, 2);