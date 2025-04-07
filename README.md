#  Sistema de Gestão de Pedidos para Restaurantes

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot, voltada para o gerenciamento de pedidos em restaurantes. A aplicação permite o cadastro e controle de itens de cardápio, além do registro e acompanhamento de pedidos realizados nas mesas.



🚀 Funcionalidades Principais


✅ Gestão de Cardápio: cadastro, edição, remoção e listagem de itens (nome, descrição, preço).

✅ Registro de Pedidos: associação de múltiplos itens do cardápio a um pedido, com controle por número da mesa e data/hora.

✅ Cálculo automático do valor total do pedido com base nos itens e quantidades.

✅ Listagem de pedidos em tempo real, com dados completos dos itens associados.

✅ Tratamento de exceções personalizado, com mensagens claras e HTTP status adequados.




🛠️ Tecnologias Utilizadas


Java 17+

Spring Boot

Spring Data JPA

H2 Database (para testes)

Maven

Insomnia/Postman para testes de requisições HTTP





📦 Estrutura do Projeto


entities/: Classes de domínio (Pedido, ItemPedido, Cardapio)

dto/: Objetos de transferência de dados para comunicação com a API

repository/: Interfaces JPA para acesso ao banco de dados

service/: Regras de negócio

controller/: Endpoints REST da aplicação

exception/: Tratamento centralizado de erros




💡 Possíveis Melhorias Futuras


Autenticação e autorização de usuários

Interface Web com React ou Angular

Suporte a múltiplos status de pedido (em preparo, finalizado, etc.)